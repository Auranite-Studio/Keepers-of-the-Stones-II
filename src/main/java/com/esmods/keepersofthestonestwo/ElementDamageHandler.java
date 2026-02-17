package com.esmods.keepersofthestonestwo;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Display.TextDisplay;
import net.minecraft.world.entity.Display.BillboardConstraints;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityLeaveLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@EventBusSubscriber(modid = PowerMod.MODID)
public class ElementDamageHandler {

	private static float baseAccumulation = 1.0f;
	private static final int THRESHOLD = 100;
	private static final int RESET_DELAY_TICKS = 300;

	private static final Map<ElementType, Integer> DAMAGE_COLORS = new EnumMap<>(ElementType.class);
	static {
		DAMAGE_COLORS.put(ElementType.FIRE, 0xFF0000);
		DAMAGE_COLORS.put(ElementType.PHYSICAL, 0xFFFF00);
	}

	private static final int DAMAGE_NUMBER_LIFETIME = 20;
	private static final int STATUS_TEXT_LIFETIME = 40;

	private static final byte FLAG_SHADOW = 1;
	private static final byte FLAG_SEE_THROUGH = 2;

	private static final Map<Integer, Long> DAMAGE_COOLDOWNS = new ConcurrentHashMap<>();
	private static final int COOLDOWN_TICKS = 5;

	private static final Map<Integer, TextDisplay> ACTIVE_DAMAGE_DISPLAYS = new ConcurrentHashMap<>();
	private static final Map<Integer, TextDisplay> ACTIVE_STATUS_DISPLAYS = new ConcurrentHashMap<>();

	private static final Map<Integer, Map<ElementType, Long>> LAST_DAMAGE_TIME = new ConcurrentHashMap<>();

	private static MinecraftServer currentServer = null;

	private static int serverTickCounter = 0;
	private static final int CLEANUP_INTERVAL = 20;

	@SubscribeEvent
	public static void onServerTick(ServerTickEvent.Pre event) {
		currentServer = event.getServer();
		serverTickCounter++;
		if (serverTickCounter >= CLEANUP_INTERVAL) {
			serverTickCounter = 0;
			cleanupStaleDisplays();
			checkAndResetInactivePoints();
		}
	}

	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		DamageSource source = event.getSource();

		// ✅ Получаем ElementType из источника (включая оружие атакующего)
		ElementType type = getElementTypeFromSource(source);

		// Если тип не определён — показываем обычный урон (белый) и выходим
		if (type == null) {
			if (canShowDamage(target)) {
				spawnDamageNumber(target, event.getOriginalDamage(), null);
			}
			return;
		}

		// ✅ Получаем атакующего и его оружие для множителя накопления
		float weaponAccumMultiplier = 1.0f;
		if (source.getEntity() instanceof LivingEntity attacker) {
			ItemStack weapon = attacker.getMainHandItem();
			// ✅ Получаем множитель накопления из оружия (реестр)
			weaponAccumMultiplier = ElementalWeaponRegistry.getAccumulationMultiplier(weapon);

			// ✅ Компонент имеет приоритет над реестром
			float componentAccum = ElementalWeaponComponent.getAccumMultiplier(weapon);
			if (componentAccum != 1.0f) {
				weaponAccumMultiplier = componentAccum;
			}
		}

		// ✅ Проверка сопротивления
		ElementResistanceManager.Resistance resistance = ElementResistanceManager.getResistance(target, type);
		PowerMod.LOGGER.debug("Resistance check: {} vs {} → {}", target.getType().toString(), type, resistance);

		// ✅ Проверка иммунитета
		if (ElementResistanceManager.isImmune(target, type)) {
			event.setNewDamage(0f);
			PowerMod.LOGGER.debug("{} is IMMUNE to {}! Damage set to 0", target.getName().getString(), type);
			return;
		}

		// ✅ 1. Накопление очков с учётом сопротивления И множителя оружия
		int basePoints = (int) baseAccumulation;
		int pointsToAdd = ElementResistanceManager.calculateAccumulationPoints(target, type, basePoints);
		pointsToAdd = Math.round(pointsToAdd * weaponAccumMultiplier); // ✅ Применяем множитель оружия

		int pointsBefore = PowerModAttachments.getPoints(target, type);
		PowerModAttachments.addPoints(target, type, pointsToAdd);
		int pointsAfter = PowerModAttachments.getPoints(target, type);
		boolean thresholdReached = pointsAfter >= THRESHOLD;

		PowerMod.LOGGER.info("Target: {} | Element: {} | WeaponAccum: x{} | Points: {} +{} → {} | Threshold: {} | Reached: {}",
				target.getName().getString(), type, weaponAccumMultiplier, pointsBefore, pointsToAdd, pointsAfter, THRESHOLD, thresholdReached);

		float finalDamage = event.getOriginalDamage();

		// ✅ 2. Применяем сопротивление к урону
		float originalDamage = finalDamage;
		finalDamage = ElementResistanceManager.calculateReducedDamage(target, type, finalDamage);
		PowerMod.LOGGER.debug("Damage calculation: {} × (1 - {}) = {} (Resistance: {})",
				originalDamage, resistance.damageResistance(), finalDamage, resistance);

		// ✅ 3. Применяем эффект порога (если достигнут)
		if (thresholdReached) {
			finalDamage = applyThresholdEffect(target, type, event, finalDamage);
			PowerModAttachments.resetPoints(target, type);
			PowerMod.LOGGER.info("THRESHOLD TRIGGERED! Reset points for {} on {}", type, target.getName().getString());
		}

		// ✅ 4. Спавним цифры урона — уже с модифицированным значением
		if (canShowDamage(target)) {
			spawnDamageNumber(target, finalDamage, type);
		}

		// ✅ Обновляем время последнего урона для авто-сброса
		updateLastDamageTime(target, type);
	}

	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		LivingEntity entity = event.getEntity();
		clearActiveDisplays(entity);
		DAMAGE_COOLDOWNS.remove(entity.getId());
		LAST_DAMAGE_TIME.remove(entity.getId());
	}

	@SubscribeEvent
	public static void onEntityLeaveLevel(EntityLeaveLevelEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof LivingEntity livingEntity) {
			clearActiveDisplays(livingEntity);
			DAMAGE_COOLDOWNS.remove(entity.getId());
			LAST_DAMAGE_TIME.remove(entity.getId());
		}
	}

	@SubscribeEvent
	public static void onLevelUnload(LevelEvent.Unload event) {
		if (event.getLevel() instanceof ServerLevel) {
			cleanupAllDisplays();
			PowerMod.LOGGER.info("ElementDamageHandler: cleaned up all displays on level unload");
		}
	}

	// ✅ === ИНТЕГРАЦИЯ С ЭЛЕМЕНТАЛЬНЫМ ОРУЖИЕМ ===

	/**
	 * Получает ElementType из источника урона.
	 * Приоритет: компонент оружия → реестр оружия → кастомный DamageType → null
	 */
	private static ElementType getElementTypeFromSource(DamageSource source) {
		// ✅ 1. Проверяем оружие атакующего (через реестр и компонент)
		if (source.getEntity() instanceof LivingEntity attacker) {
			ItemStack weapon = attacker.getMainHandItem();

			// Сначала проверяем компонент (более специфичный)
			Optional<ElementType> componentType = ElementalWeaponComponent.getElement(weapon);
			if (componentType.isPresent()) {
				return componentType.get();
			}

			// Потом проверяем реестр
			ElementType registryType = ElementalWeaponRegistry.getElementType(weapon);
			if (registryType != null) {
				return registryType;
			}
		}

		// ✅ 2. Проверяем кастомные DamageType (для совместимости)
		String msgId = source.type().msgId();
		for (ElementType type : ElementType.values()) {
			if (type.getDamageTypeId().equals(msgId)) {
				return type;
			}
		}

		PowerMod.LOGGER.debug("No matching ElementType for msgId: {}", msgId);
		return null;
	}

	/**
	 * Публичный метод для получения ElementType из предмета.
	 */
	public static ElementType getElementTypeFromItem(ItemStack stack) {
		if (stack == null || stack.isEmpty()) return null;

		// Сначала проверяем компонент (более специфичный)
		Optional<ElementType> componentType = ElementalWeaponComponent.getElement(stack);
		if (componentType.isPresent()) {
			return componentType.get();
		}

		// Потом проверяем реестр
		return ElementalWeaponRegistry.getElementType(stack);
	}

	/**
	 * Создаёт элементальную копию предмета.
	 */
	public static ItemStack createElementalItem(net.minecraft.world.item.Item item, ElementType type, int count) {
		ItemStack stack = new ItemStack(item, count);
		return ElementalWeaponComponent.withElement(stack, type);
	}

	/**
	 * Создаёт элементальную копию предмета с кастомным множителем накопления.
	 */
	public static ItemStack createElementalItemWithAccum(net.minecraft.world.item.Item item, ElementType type, int count, float accumMultiplier) {
		ItemStack stack = new ItemStack(item, count);
		return ElementalWeaponComponent.withElementAndAccum(stack, type, accumMultiplier);
	}

	// ✅ === ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ===

	private static void updateLastDamageTime(LivingEntity entity, ElementType type) {
		int entityId = entity.getId();
		long gameTime = entity.level().getGameTime();

		LAST_DAMAGE_TIME.computeIfAbsent(entityId, k -> new EnumMap<>(ElementType.class))
				.put(type, gameTime);
	}

	private static void checkAndResetInactivePoints() {
		if (currentServer == null) return;

		long currentTime = currentServer.overworld().getGameTime();

		Iterator<Map.Entry<Integer, Map<ElementType, Long>>> entityIterator = LAST_DAMAGE_TIME.entrySet().iterator();
		while (entityIterator.hasNext()) {
			Map.Entry<Integer, Map<ElementType, Long>> entityEntry = entityIterator.next();
			int entityId = entityEntry.getKey();
			Map<ElementType, Long> typeTimes = entityEntry.getValue();

			LivingEntity livingEntity = null;
			for (ServerLevel level : currentServer.getAllLevels()) {
				Entity entity = level.getEntity(entityId);
				if (entity instanceof LivingEntity le && le.isAlive()) {
					livingEntity = le;
					break;
				}
			}

			if (livingEntity == null) {
				entityIterator.remove();
				continue;
			}

			Iterator<Map.Entry<ElementType, Long>> typeIterator = typeTimes.entrySet().iterator();
			while (typeIterator.hasNext()) {
				Map.Entry<ElementType, Long> typeEntry = typeIterator.next();
				ElementType type = typeEntry.getKey();
				long lastTime = typeEntry.getValue();

				if (currentTime - lastTime >= RESET_DELAY_TICKS) {
					int pointsBefore = PowerModAttachments.getPoints(livingEntity, type);
					if (pointsBefore > 0) {
						PowerModAttachments.resetPoints(livingEntity, type);
						PowerMod.LOGGER.debug("Reset {} points for {} (inactive for {} ticks)",
								pointsBefore, type, RESET_DELAY_TICKS);
					}
					typeIterator.remove();
				}
			}

			if (typeTimes.isEmpty()) {
				entityIterator.remove();
			}
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
		LAST_DAMAGE_TIME.clear();
	}

	private static void cleanupStaleDisplays() {
		int cleanedCount = 0;

		Iterator<Map.Entry<Integer, TextDisplay>> damageIterator = ACTIVE_DAMAGE_DISPLAYS.entrySet().iterator();
		while (damageIterator.hasNext()) {
			Map.Entry<Integer, TextDisplay> entry = damageIterator.next();
			TextDisplay display = entry.getValue();

			if (display == null || display.isRemoved() || display.level() == null) {
				damageIterator.remove();
				cleanedCount++;
				continue;
			}

			Entity target = display.level().getEntity(entry.getKey());
			if (target == null || !target.isAlive()) {
				if (!display.isRemoved()) {
					display.discard();
				}
				damageIterator.remove();
				cleanedCount++;
			}
		}

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

		DAMAGE_COOLDOWNS.entrySet().removeIf(entry -> false);

		if (cleanedCount > 0) {
			PowerMod.LOGGER.debug("ElementDamageHandler: cleaned {} stale displays", cleanedCount);
		}
	}

	// === МЕТОДЫ ДЛЯ РАБОТЫ С ПОРОГАМИ ===

	public static int getThreshold() {
		return THRESHOLD;
	}

	public static void setThreshold(int threshold) {
		PowerMod.LOGGER.warn("setThreshold() deprecated - all types use THRESHOLD = 100");
	}

	// === МЕТОДЫ ДЛЯ РАБОТЫ С ЦВЕТАМИ ===

	private static int getDamageColor(ElementType type) {
		if (type == null) {
			return 0xFFFFFF; // Белый для обычного урона
		}
		return DAMAGE_COLORS.getOrDefault(type, 0xFFFFFF);
	}

	public static void setDamageColor(ElementType type, int color) {
		DAMAGE_COLORS.put(type, color);
	}

	public static Map<ElementType, Integer> getAllDamageColors() {
		return new EnumMap<>(DAMAGE_COLORS);
	}

	// === ЭФФЕКТЫ ПОРОГА ===

	private static float applyThresholdEffect(LivingEntity target, ElementType type, LivingDamageEvent.Pre event, float currentDamage) {
		PowerMod.LOGGER.info("THRESHOLD REACHED! Entity: {}, Type: {}", target.getName().getString(), type);

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
		PowerMod.LOGGER.info("THRESHOLD REACHED! Entity: {}, Type: {}", target.getName().getString(), type);

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

	// === СПАВН ВИЗУАЛЬНЫХ ЭФФЕКТОВ ===

	private static void spawnDamageNumber(LivingEntity entity, float amount, ElementType type) {
		if (!(entity.level() instanceof ServerLevel serverLevel)) return;

		int entityId = entity.getId();

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

		if (ElementResistanceManager.isImmune(target, type)) {
			PowerMod.LOGGER.debug("{} is IMMUNE to {} (manual call)!", target.getName().getString(), type);
			return;
		}

		var damageTypeRegistry = serverLevel.registryAccess()
				.registryOrThrow(Registries.DAMAGE_TYPE);

		var rl = ResourceLocation.fromNamespaceAndPath("power", type.getDamageTypeId());
		var damageTypeHolder = damageTypeRegistry.getHolder(rl);

		if (damageTypeHolder.isEmpty()) {
			PowerMod.LOGGER.error("Damage type NOT FOUND: {} - урон НЕ будет нанесён!", rl);
			return;
		}

		DamageSource source = new DamageSource(damageTypeHolder.get());
		float finalDamage = amount;

		finalDamage = ElementResistanceManager.calculateReducedDamage(livingTarget, type, finalDamage);

		// ✅ Поддержка множителя накопления через отрицательное значение
		float weaponAccumMultiplier = 1.0f;
		int basePoints;
		if (accumulationPoints < 0) {
			// Специальный режим: accumulationPoints = -multiplier (например -2.5f = множитель 2.5)
			weaponAccumMultiplier = Math.abs(accumulationPoints);
			basePoints = (int) baseAccumulation;
		} else {
			basePoints = (accumulationPoints > 0) ? accumulationPoints : (int) baseAccumulation;
		}

		int pointsToAdd = ElementResistanceManager.calculateAccumulationPoints(livingTarget, type, basePoints);
		pointsToAdd = Math.round(pointsToAdd * weaponAccumMultiplier);

		if (pointsToAdd > 0) {
			int pointsBefore = PowerModAttachments.getPoints(livingTarget, type);
			PowerModAttachments.addPoints(livingTarget, type, pointsToAdd);
			int pointsAfter = PowerModAttachments.getPoints(livingTarget, type);
			boolean thresholdReached = pointsAfter >= THRESHOLD;

			PowerMod.LOGGER.info("[Manual] Target: {} | Element: {} | WeaponAccum: x{} | Points: {} +{} → {} | Threshold: {} | Reached: {}",
					livingTarget.getName().getString(), type, weaponAccumMultiplier, pointsBefore, pointsToAdd, pointsAfter, THRESHOLD, thresholdReached);

			if (thresholdReached) {
				finalDamage = applyThresholdEffectWithDamage(livingTarget, type, amount);
				PowerModAttachments.resetPoints(livingTarget, type);
				PowerMod.LOGGER.info("[Manual] THRESHOLD TRIGGERED! Reset points for {} on {}", type, livingTarget.getName().getString());
			}

			if (canShowDamage(livingTarget)) {
				spawnDamageNumber(livingTarget, finalDamage, type);
			}
		} else {
			if (canShowDamage(livingTarget)) {
				spawnDamageNumber(livingTarget, finalDamage, type);
			}
		}

		target.hurt(source, finalDamage);

		updateLastDamageTime(livingTarget, type);
	}

	/**
	 * Наносит элементальный урон с кастомным множителем накопления.
	 * @param accumMultiplier множитель накопления (1.0 = стандарт, 2.0 = двойное)
	 */
	public static void dealElementDamageWithAccum(Entity target, ElementType type, float amount, float accumMultiplier) {
		if (!(target.level() instanceof ServerLevel serverLevel)) {
			PowerMod.LOGGER.warn("dealElementDamageWithAccum: not server level");
			return;
		}
		if (!(target instanceof LivingEntity livingTarget)) {
			PowerMod.LOGGER.warn("dealElementDamageWithAccum: target is not LivingEntity");
			return;
		}

		if (ElementResistanceManager.isImmune(target, type)) {
			PowerMod.LOGGER.debug("{} is IMMUNE to {} (manual call)!", target.getName().getString(), type);
			return;
		}

		var damageTypeRegistry = serverLevel.registryAccess()
				.registryOrThrow(Registries.DAMAGE_TYPE);

		var rl = ResourceLocation.fromNamespaceAndPath("power", type.getDamageTypeId());
		var damageTypeHolder = damageTypeRegistry.getHolder(rl);

		if (damageTypeHolder.isEmpty()) {
			PowerMod.LOGGER.error("Damage type NOT FOUND: {} - урон НЕ будет нанесён!", rl);
			return;
		}

		DamageSource source = new DamageSource(damageTypeHolder.get());
		float finalDamage = amount;

		finalDamage = ElementResistanceManager.calculateReducedDamage(livingTarget, type, finalDamage);

		int basePoints = (int) baseAccumulation;
		int pointsToAdd = ElementResistanceManager.calculateAccumulationPoints(livingTarget, type, basePoints);
		pointsToAdd = Math.round(pointsToAdd * accumMultiplier);

		if (pointsToAdd > 0) {
			int pointsBefore = PowerModAttachments.getPoints(livingTarget, type);
			PowerModAttachments.addPoints(livingTarget, type, pointsToAdd);
			int pointsAfter = PowerModAttachments.getPoints(livingTarget, type);
			boolean thresholdReached = pointsAfter >= THRESHOLD;

			PowerMod.LOGGER.info("[Manual] Target: {} | Element: {} | WeaponAccum: x{} | Points: {} +{} → {} | Threshold: {} | Reached: {}",
					livingTarget.getName().getString(), type, accumMultiplier, pointsBefore, pointsToAdd, pointsAfter, THRESHOLD, thresholdReached);

			if (thresholdReached) {
				finalDamage = applyThresholdEffectWithDamage(livingTarget, type, amount);
				PowerModAttachments.resetPoints(livingTarget, type);
				PowerMod.LOGGER.info("[Manual] THRESHOLD TRIGGERED! Reset points for {} on {}", type, livingTarget.getName().getString());
			}

			if (canShowDamage(livingTarget)) {
				spawnDamageNumber(livingTarget, finalDamage, type);
			}
		} else {
			if (canShowDamage(livingTarget)) {
				spawnDamageNumber(livingTarget, finalDamage, type);
			}
		}

		target.hurt(source, finalDamage);

		updateLastDamageTime(livingTarget, type);
	}

	public static void addElementPoints(LivingEntity entity, ElementType type, int points) {
		int pointsToAdd = ElementResistanceManager.calculateAccumulationPoints(entity, type, points);
		PowerModAttachments.addPoints(entity, type, pointsToAdd);
		updateLastDamageTime(entity, type);
	}

	public static int getElementPoints(LivingEntity entity, ElementType type) {
		return PowerModAttachments.getPoints(entity, type);
	}

	public static void resetElementPoints(LivingEntity entity, ElementType type) {
		PowerModAttachments.resetPoints(entity, type);
		LAST_DAMAGE_TIME.computeIfPresent(entity.getId(), (id, map) -> {
			map.remove(type);
			return map.isEmpty() ? null : map;
		});
	}

	public static void resetAllElementPoints(LivingEntity entity) {
		for (ElementType type : ElementType.values()) {
			PowerModAttachments.resetPoints(entity, type);
		}
		LAST_DAMAGE_TIME.remove(entity.getId());
	}

	public static int getAccumulationProgress(LivingEntity entity, ElementType type) {
		int points = getElementPoints(entity, type);
		return THRESHOLD > 0 ? (points * 100) / THRESHOLD : 0;
	}

	public static ElementResistanceManager.Resistance getEntityResistance(Entity entity, ElementType type) {
		return ElementResistanceManager.getResistance(entity, type);
	}
}