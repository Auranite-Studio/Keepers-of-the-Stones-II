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
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.WeakHashMap;

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
	private static final Map<Integer, Long> DAMAGE_COOLDOWNS = new WeakHashMap<>();
	private static final int COOLDOWN_TICKS = 5;

	// === ОТСЛЕЖИВАНИЕ АКТИВНЫХ ТЕКСТОВ ===
	private static final Map<Integer, TextDisplay> ACTIVE_DAMAGE_DISPLAYS = new WeakHashMap<>();
	private static final Map<Integer, TextDisplay> ACTIVE_STATUS_DISPLAYS = new WeakHashMap<>();

	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		// ✅ target = получатель урона (сущность, которую бьют)
		LivingEntity target = event.getEntity();
		DamageSource source = event.getSource();

		ElementType type = getElementTypeFromSource(source);
		if (type == null) return;

		// ✅ 1. Накопление очков на ЦЕЛИ (target)
		int pointsBefore = PowerModAttachments.getPoints(target, type);
		PowerModAttachments.addPoints(target, type, (int) baseAccumulation);
		int pointsAfter = PowerModAttachments.getPoints(target, type);

		// ✅ 2. Проверка порога
		boolean thresholdReached = pointsAfter >= THRESHOLD;

		PowerMod.LOGGER.info("⚡ Target: {} | Element: {} | Points: {} → {} | Threshold: {} | Reached: {}",
				target.getName().getString(), type, pointsBefore, pointsAfter, THRESHOLD, thresholdReached);

		float finalDamage = event.getOriginalDamage();

		// ✅ 3. Цифры урона отображаются ВСЕГДА (независимо от порога)
		if (canShowDamage(target)) {
			spawnDamageNumber(target, finalDamage, type);
		}

		// ✅ 4. Если порог достигнут — применяем эффект и показываем статусный текст
		if (thresholdReached) {
			finalDamage = applyThresholdEffect(target, type, event, finalDamage);
			// ✅ Сброс очков ТОЛЬКО для этого типа на ЦЕЛИ
			PowerModAttachments.resetPoints(target, type);
			PowerMod.LOGGER.info("✅ THRESHOLD TRIGGERED! Reset points for {} on {}", type, target.getName().getString());
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

		TextDisplay oldDamageDisplay = ACTIVE_DAMAGE_DISPLAYS.get(entityId);
		if (oldDamageDisplay != null && !oldDamageDisplay.isRemoved()) {
			oldDamageDisplay.discard();
		}
		ACTIVE_DAMAGE_DISPLAYS.remove(entityId);

		TextDisplay oldStatusDisplay = ACTIVE_STATUS_DISPLAYS.get(entityId);
		if (oldStatusDisplay != null && !oldStatusDisplay.isRemoved()) {
			oldStatusDisplay.discard();
		}
		ACTIVE_STATUS_DISPLAYS.remove(entityId);
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
		// Для совместимости, но теперь все типы используют одно значение
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
				// ✅ Статусный текст ТОЛЬКО при достижении порога
				spawnStatusText(target, "🔥 OVERHEATING!", 0xFF5500);
				yield currentDamage;
			}
			case PHYSICAL -> {
				float newDamage = currentDamage * 5.0f;
				event.setNewDamage(newDamage);
				// ✅ Статусный текст ТОЛЬКО при достижении порога
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

		// ✅ Удаляем старый текст урона перед созданием нового
		int entityId = entity.getId();
		TextDisplay oldDamageDisplay = ACTIVE_DAMAGE_DISPLAYS.get(entityId);
		if (oldDamageDisplay != null && !oldDamageDisplay.isRemoved()) {
			oldDamageDisplay.discard();
		}
		ACTIVE_DAMAGE_DISPLAYS.remove(entityId);

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
			PowerMod.queueServerWork(DAMAGE_NUMBER_LIFETIME, () -> {
				display.discard();
				ACTIVE_DAMAGE_DISPLAYS.remove(entityId);
			});
		}
	}

	private static void spawnStatusText(LivingEntity entity, String text, int color) {
		if (!(entity.level() instanceof ServerLevel serverLevel)) return;

		// ✅ Удаляем старый статусный текст
		int entityId = entity.getId();
		TextDisplay oldStatus = ACTIVE_STATUS_DISPLAYS.get(entityId);
		if (oldStatus != null && !oldStatus.isRemoved()) {
			oldStatus.discard();
		}
		ACTIVE_STATUS_DISPLAYS.remove(entityId);

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
			PowerMod.queueServerWork(STATUS_TEXT_LIFETIME, () -> {
				display.discard();
				ACTIVE_STATUS_DISPLAYS.remove(entityId);
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

	public static void dealElementDamage(Entity target, ElementType type, float amount) {
		dealElementDamage(target, type, amount, 0);
	}

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

		if (accumulationPoints > 0) {
			// ✅ Накопление на ЦЕЛИ
			int pointsBefore = PowerModAttachments.getPoints(livingTarget, type);
			PowerModAttachments.addPoints(livingTarget, type, accumulationPoints);
			int pointsAfter = PowerModAttachments.getPoints(livingTarget, type);

			boolean thresholdReached = pointsAfter >= THRESHOLD;

			PowerMod.LOGGER.info("⚡ [Manual] Target: {} | Element: {} | Points: {} → {} | Threshold: {} | Reached: {}",
					livingTarget.getName().getString(), type, pointsBefore, pointsAfter, THRESHOLD, thresholdReached);

			// ✅ Цифры урона ВСЕГДА
			if (canShowDamage(livingTarget)) {
				spawnDamageNumber(livingTarget, finalDamage, type);
			}

			// ✅ Статусный текст ТОЛЬКО при пороге
			if (thresholdReached) {
				finalDamage = applyThresholdEffectWithDamage(livingTarget, type, amount);
				PowerModAttachments.resetPoints(livingTarget, type);
				PowerMod.LOGGER.info("✅ [Manual] THRESHOLD TRIGGERED! Reset points for {} on {}", type, livingTarget.getName().getString());
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

	public static int getAccumulationProgress(LivingEntity entity, ElementType type) {
		int points = getElementPoints(entity, type);
		return THRESHOLD > 0 ? (points * 100) / THRESHOLD : 0;
	}
}