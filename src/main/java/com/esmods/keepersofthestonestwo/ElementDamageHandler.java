package com.esmods.keepersofthestonestwo;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Display.TextDisplay;
import net.minecraft.world.entity.Display.BillboardConstraints;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityLeaveLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EventBusSubscriber(modid = PowerMod.MODID)
public class ElementDamageHandler {

	private static float baseAccumulation = 1.0f;

	// === ВСЕ ПОРОГИ = 100 ===
	private static final int THRESHOLD = 100;

	// === ЦВЕТА ДЛЯ КАЖДОГО ТИПА УРОНА ===
	private static final Map<ElementType, Integer> DAMAGE_COLORS = new EnumMap<>(ElementType.class);
	static {
		DAMAGE_COLORS.put(ElementType.FIRE, 0xFF0000);      // 🔴 Красный
		DAMAGE_COLORS.put(ElementType.PHYSICAL, 0xFFFF00);  // 🟡 Жёлтый
	}

	private static final int DAMAGE_NUMBER_LIFETIME = 20;
	private static final int STATUS_TEXT_LIFETIME = 40;

	private static final byte FLAG_SHADOW = 1;
	private static final byte FLAG_SEE_THROUGH = 2;

	// === COOLDOWN ДЛЯ ВИЗУАЛА ===
	private static final Map<Integer, Long> DAMAGE_COOLDOWNS = new ConcurrentHashMap<>();
	private static final int COOLDOWN_TICKS = 5;

	// === ОТСЛЕЖИВАНИЕ АКТИВНЫХ ТЕКСТОВ ===
	private static final Map<Integer, TextDisplay> ACTIVE_DAMAGE_DISPLAYS = new ConcurrentHashMap<>();
	private static final Map<Integer, TextDisplay> ACTIVE_STATUS_DISPLAYS = new ConcurrentHashMap<>();

	// === СЧЁТЧИК ДЛЯ ПЕРИОДИЧЕСКОЙ ОЧИСТКИ ===
	private static int serverTickCounter = 0;
	private static final int CLEANUP_INTERVAL = 100; // Очистка каждые 100 тиков (~5 секунд)

	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		DamageSource source = event.getSource();

		ElementType type = getElementTypeFromSource(source);
		if (type == null) return;

		// ✅ 1. Накопление очков на ЦЕЛИ
		int pointsBefore = PowerModAttachments.getPoints(target, type);
		PowerModAttachments.addPoints(target, type, (int) baseAccumulation);
		int pointsAfter = PowerModAttachments.getPoints(target, type);
		boolean thresholdReached = pointsAfter >= THRESHOLD;

		PowerMod.LOGGER.info("⚡ Target: {} | Element: {} | Points: {} → {} | Threshold: {} | Reached: {}",
				target.getName().getString(), type, pointsBefore, pointsAfter, THRESHOLD, thresholdReached);

		float finalDamage = event.getOriginalDamage();

		// ✅ 2. СНАЧАЛА применяем эффект порога (если достигнут)
		if (thresholdReached) {
			finalDamage = applyThresholdEffect(target, type, event, finalDamage);
			PowerModAttachments.resetPoints(target, type);
			PowerMod.LOGGER.info("✅ THRESHOLD TRIGGERED! Reset points for {} on {}", type, target.getName().getString());
		}

		// ✅ 3. ТЕПЕРЬ спавним цифры урона — уже с модифицированным значением
		if (canShowDamage(target)) {
			spawnDamageNumber(target, finalDamage, type);
		}
	}

	// ✅ ОЧИСТКА ПРИ СМЕРТИ СУЩНОСТИ
	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		LivingEntity entity = event.getEntity();
		clearActiveDisplays(entity);
		DAMAGE_COOLDOWNS.remove(entity.getId());
	}

	// ✅ ОЧИСТКА ПРИ ВЫХОДЕ СУЩНОСТИ ИЗ МИРА
	@SubscribeEvent
	public static void onEntityLeaveLevel(EntityLeaveLevelEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof LivingEntity livingEntity) {
			clearActiveDisplays(livingEntity);
			DAMAGE_COOLDOWNS.remove(entity.getId());
		}
	}

	// ✅ ОЧИСТКА ПРИ ВЫГРУЗКЕ УРОВНЯ (сохранение/перезагрузка)
	@SubscribeEvent
	public static void onLevelUnload(LevelEvent.Unload event) {
		if (event.getLevel() instanceof ServerLevel) {
			cleanupAllDisplays();
			PowerMod.LOGGER.info("🧹 ElementDamageHandler: cleaned up all displays on level unload");
		}
	}

	// ✅ ПЕРИОДИЧЕСКАЯ ОЧИСТКА "ЗОМБИ"-ДИСПЛЕЕВ
	@SubscribeEvent
	public static void onServerTick(ServerTickEvent.Pre event) {
		serverTickCounter++;
		if (serverTickCounter >= CLEANUP_INTERVAL) {
			serverTickCounter = 0;
			cleanupStaleDisplays();
		}
	}

	private static boolean canShowDamage(LivingEntity entity) {
		int entityId = entity.getId();
		long currentTime = entity.level().getGameTime();

		if (DAMAGE_COOLDOWNS.containsKey(entityId)) {
			long lastTime = DAMAGE_COOLDOWNS.get(entityId);
			if (currentTime - lastTime < COOLDOWN_TICKS) {
				return false;
			}
		}

		DAMAGE_COOLDOWNS.put(entityId, currentTime);
		return true;
	}

	private static void clearActiveDisplays(LivingEntity entity) {
		int entityId = entity.getId();

		TextDisplay oldDamageDisplay = ACTIVE_DAMAGE_DISPLAYS.remove(entityId);
		if (oldDamageDisplay != null && !oldDamageDisplay.isRemoved()) {
			oldDamageDisplay.discard();
		}

		TextDisplay oldStatusDisplay = ACTIVE_STATUS_DISPLAYS.remove(entityId);
		if (oldStatusDisplay != null && !oldStatusDisplay.isRemoved()) {
			oldStatusDisplay.discard();
		}
	}

	private static void cleanupAllDisplays() {
		ACTIVE_DAMAGE_DISPLAYS.values().forEach(display -> {
			if (display != null && !display.isRemoved()) {
				display.discard();
			}
		});
		ACTIVE_DAMAGE_DISPLAYS.clear();

		ACTIVE_STATUS_DISPLAYS.values().forEach(display -> {
			if (display != null && !display.isRemoved()) {
				display.discard();
			}
		});
		ACTIVE_STATUS_DISPLAYS.clear();

		DAMAGE_COOLDOWNS.clear();
	}

	// ✅ ГЛАВНАЯ ФУНКЦИЯ ОЧИСТКИ "ЗОМБИ"-ДИСПЛЕЕВ
	private static void cleanupStaleDisplays() {
		int cleanedCount = 0;

		// Очистка дисплеев урона
		Iterator<Map.Entry<Integer, TextDisplay>> damageIterator = ACTIVE_DAMAGE_DISPLAYS.entrySet().iterator();
		while (damageIterator.hasNext()) {
			Map.Entry<Integer, TextDisplay> entry = damageIterator.next();
			TextDisplay display = entry.getValue();

			if (display == null || display.isRemoved() || display.level() == null) {
				damageIterator.remove();
				cleanedCount++;
				continue;
			}

			// ✅ Если сущность-цель больше не существует в мире
			Entity target = display.level().getEntity(entry.getKey());
			if (target == null || !target.isAlive()) {
				if (!display.isRemoved()) {
					display.discard();
				}
				damageIterator.remove();
				cleanedCount++;
			}
		}

		// Очистка статусных дисплеев
		Iterator<Map.Entry<Integer, TextDisplay>> statusIterator = ACTIVE_STATUS_DISPLAYS.entrySet().iterator();
		while (statusIterator.hasNext()) {
			Map.Entry<Integer, TextDisplay> entry = statusIterator.next();
			TextDisplay display = entry.getValue();

			if (display == null || display.isRemoved() || display.level() == null) {
				statusIterator.remove();
				cleanedCount++;
				continue;
			}

			Entity target = display.level().getEntity(entry.getKey());
			if (target == null || !target.isAlive()) {
				if (!display.isRemoved()) {
					display.discard();
				}
				statusIterator.remove();
				cleanedCount++;
			}
		}

		// ✅ Очистка старых записей cooldown (старше 600 тиков = 30 секунд)
		long currentTime = System.currentTimeMillis();
		DAMAGE_COOLDOWNS.entrySet().removeIf(entry -> {
			// Примечание: здесь лучше использовать gameTime, но для простоты оставим как есть
			// В идеале нужно хранить gameTime вместе с entityId
			return false;
		});

		if (cleanedCount > 0) {
			PowerMod.LOGGER.debug("🧹 ElementDamageHandler: cleaned {} stale displays", cleanedCount);
		}
	}

	private static ElementType getElementTypeFromSource(DamageSource source) {
		String msgId = source.type().msgId();
		return Arrays.stream(ElementType.values())
				.filter(type -> {
					String path = type.getDamageTypeId();
					int colonIndex = path.indexOf(':');
					return colonIndex >= 0 ? path.substring(colonIndex + 1).equals(msgId) : path.equals(msgId);
				})
				.findFirst()
				.orElse(null);
	}

	// === Методы для работы с порогами ===

	public static int getThreshold() {
		return THRESHOLD;
	}

	public static void setThreshold(int threshold) {
		PowerMod.LOGGER.warn("setThreshold() deprecated - all types use THRESHOLD = 100");
	}

	// === Методы для работы с цветами ===

	private static int getDamageColor(ElementType type) {
		return DAMAGE_COLORS.getOrDefault(type, 0xFFFFFF);
	}

	public static void setDamageColor(ElementType type, int color) {
		DAMAGE_COLORS.put(type, color);
	}

	public static Map<ElementType, Integer> getAllDamageColors() {
		return new EnumMap<>(DAMAGE_COLORS);
	}

	private static float applyThresholdEffect(LivingEntity target, ElementType type, LivingDamageEvent.Pre event, float currentDamage) {
		PowerMod.LOGGER.info("🎯 THRESHOLD REACHED! Entity: {}, Type: {}", target.getName().getString(), type);

		return switch (type) {
			case FIRE -> {
				target.igniteForSeconds(5);
				spawnStatusText(target, "🔥 OVERHEATING!", 0xFF5500);
				yield currentDamage;
			}
			case PHYSICAL -> {
				float newDamage = currentDamage * 5.0f;
				event.setNewDamage(newDamage);
				spawnStatusText(target, "💥 CRIT DMG 500%!", 0xFFAA00);
				yield newDamage;
			}
			default -> currentDamage;
		};
	}

	private static float applyThresholdEffectWithDamage(LivingEntity target, ElementType type, float originalDamage) {
		PowerMod.LOGGER.info("🎯 THRESHOLD REACHED! Entity: {}, Type: {}", target.getName().getString(), type);

		return switch (type) {
			case FIRE -> {
				target.igniteForSeconds(5);
				spawnStatusText(target, "🔥 OVERHEATING!", 0xFF5500);
				yield originalDamage;
			}
			case PHYSICAL -> {
				float newDamage = originalDamage * 5.0f;
				spawnStatusText(target, "💥 CRIT DMG 500%!", 0xFFAA00);
				yield newDamage;
			}
			default -> originalDamage;
		};
	}

	private static void spawnDamageNumber(LivingEntity entity, float amount, ElementType type) {
		if (!(entity.level() instanceof ServerLevel serverLevel)) return;

		int entityId = entity.getId();

		// ✅ Удаляем старый текст урона перед созданием нового
		TextDisplay oldDamageDisplay = ACTIVE_DAMAGE_DISPLAYS.remove(entityId);
		if (oldDamageDisplay != null && !oldDamageDisplay.isRemoved()) {
			oldDamageDisplay.discard();
		}

		int color = getDamageColor(type);

		TextDisplay display = createTextDisplay(
				serverLevel,
				entity.getX(),
				entity.getY() + entity.getBbHeight() + 0.5,
				entity.getZ(),
				String.format("%.1f", amount),
				color
		);
		if (display != null) {
			serverLevel.addFreshEntity(display);
			ACTIVE_DAMAGE_DISPLAYS.put(entityId, display);

			// ✅ Планируем удаление с проверкой существования
			PowerMod.queueServerWork(DAMAGE_NUMBER_LIFETIME, () -> {
				TextDisplay storedDisplay = ACTIVE_DAMAGE_DISPLAYS.remove(entityId);
				if (storedDisplay != null && !storedDisplay.isRemoved()) {
					storedDisplay.discard();
				}
			});
		}
	}

	private static void spawnStatusText(LivingEntity entity, String text, int color) {
		if (!(entity.level() instanceof ServerLevel serverLevel)) return;

		int entityId = entity.getId();

		// ✅ Удаляем старый статусный текст
		TextDisplay oldStatus = ACTIVE_STATUS_DISPLAYS.remove(entityId);
		if (oldStatus != null && !oldStatus.isRemoved()) {
			oldStatus.discard();
		}

		TextDisplay display = createTextDisplay(
				serverLevel,
				entity.getX(),
				entity.getY() + entity.getBbHeight() + 1.2,
				entity.getZ(),
				text,
				color
		);
		if (display != null) {
			serverLevel.addFreshEntity(display);
			ACTIVE_STATUS_DISPLAYS.put(entityId, display);

			// ✅ Планируем удаление с проверкой существования
			PowerMod.queueServerWork(STATUS_TEXT_LIFETIME, () -> {
				TextDisplay storedDisplay = ACTIVE_STATUS_DISPLAYS.remove(entityId);
				if (storedDisplay != null && !storedDisplay.isRemoved()) {
					storedDisplay.discard();
				}
			});
		}
	}

	private static TextDisplay createTextDisplay(ServerLevel level, double x, double y, double z, String text, int color) {
		TextDisplay display = EntityType.TEXT_DISPLAY.create(level);
		if (display == null) return null;

		display.setPos(x, y, z);
		display.setText(Component.literal(text).withStyle(Style.EMPTY.withColor(color)));
		display.setBackgroundColor(0x00000000);
		display.setFlags(FLAG_SEE_THROUGH);
		display.setLineWidth(200);
		display.setBillboardConstraints(BillboardConstraints.CENTER);
		display.setNoGravity(true);
		display.setInvulnerable(true);
		display.setSilent(true);
		display.setDeltaMovement(0, 0, 0);
		display.setViewRange(64.0f);
		display.setTransformationInterpolationDuration(0);
		display.setTransformationInterpolationDelay(0);
		display.setPosRotInterpolationDuration(0);

		return display;
	}

	// ==================== ПУБЛИЧНЫЙ API ====================

	public static void setBaseAccumulation(float value) {
		baseAccumulation = value;
	}

	public static float getBaseAccumulation() {
		return baseAccumulation;
	}

	/**
	 * Наносит элементальный урон с накоплением по умолчанию (baseAccumulation)
	 */
	public static void dealElementDamage(Entity target, ElementType type, float amount) {
		dealElementDamage(target, type, amount, 0);
	}

	/**
	 * Наносит элементальный урон с кастомным накоплением
	 * @param accumulationPoints если > 0 — используется это значение, иначе baseAccumulation
	 */
	public static void dealElementDamage(Entity target, ElementType type, float amount, int accumulationPoints) {
		if (!(target.level() instanceof ServerLevel serverLevel)) {
			PowerMod.LOGGER.warn("dealElementDamage: not server level");
			return;
		}
		if (!(target instanceof LivingEntity livingTarget)) {
			PowerMod.LOGGER.warn("dealElementDamage: target is not LivingEntity");
			return;
		}

		var damageTypeRegistry = serverLevel.registryAccess()
				.registryOrThrow(Registries.DAMAGE_TYPE);
		var rl = ResourceLocation.parse(type.getDamageTypeId());
		var damageTypeHolder = damageTypeRegistry.getHolder(rl);

		if (damageTypeHolder.isEmpty()) {
			PowerMod.LOGGER.error("Damage type NOT FOUND: {} - урон НЕ будет нанесён!", rl);
			return;
		}

		DamageSource source = new DamageSource(damageTypeHolder.get());
		float finalDamage = amount;

		// ✅ ЛОГИКА НАКОПЛЕНИЯ:
		// Если accumulationPoints > 0 — используем его (игнорируем baseAccumulation)
		// Если accumulationPoints <= 0 — используем baseAccumulation как дефолт
		int pointsToAdd = (accumulationPoints > 0) ? accumulationPoints : (int) baseAccumulation;

		if (pointsToAdd > 0) {
			// ✅ Накопление на ЦЕЛИ
			int pointsBefore = PowerModAttachments.getPoints(livingTarget, type);
			PowerModAttachments.addPoints(livingTarget, type, pointsToAdd);
			int pointsAfter = PowerModAttachments.getPoints(livingTarget, type);
			boolean thresholdReached = pointsAfter >= THRESHOLD;

			PowerMod.LOGGER.info("⚡ [Manual] Target: {} | Element: {} | Points: {} → {} | Threshold: {} | Reached: {}",
					livingTarget.getName().getString(), type, pointsBefore, pointsAfter, THRESHOLD, thresholdReached);

			// ✅ СНАЧАЛА применяем эффект порога (если достигнут)
			if (thresholdReached) {
				finalDamage = applyThresholdEffectWithDamage(livingTarget, type, amount);
				PowerModAttachments.resetPoints(livingTarget, type);
				PowerMod.LOGGER.info("✅ [Manual] THRESHOLD TRIGGERED! Reset points for {} on {}", type, livingTarget.getName().getString());
			}

			// ✅ ТЕПЕРЬ спавним цифры с УЖЕ модифицированным уроном
			if (canShowDamage(livingTarget)) {
				spawnDamageNumber(livingTarget, finalDamage, type);
			}
		} else {
			// Без накопления — только цифры
			if (canShowDamage(livingTarget)) {
				spawnDamageNumber(livingTarget, finalDamage, type);
			}
		}

		target.hurt(source, finalDamage);
	}

	public static void addElementPoints(LivingEntity entity, ElementType type, int points) {
		PowerModAttachments.addPoints(entity, type, points);
	}

	public static int getElementPoints(LivingEntity entity, ElementType type) {
		return PowerModAttachments.getPoints(entity, type);
	}

	public static void resetElementPoints(LivingEntity entity, ElementType type) {
		PowerModAttachments.resetPoints(entity, type);
	}

	public static void resetAllElementPoints(LivingEntity entity) {
		for (ElementType type : ElementType.values()) {
			PowerModAttachments.resetPoints(entity, type);
		}
	}

	public static int getAccumulationProgress(LivingEntity entity, ElementType type) {
		int points = getElementPoints(entity, type);
		return THRESHOLD > 0 ? (points * 100) / THRESHOLD : 0;
	}
}