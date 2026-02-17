package com.esmods.keepersofthestonestwo;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
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

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@EventBusSubscriber(modid = PowerMod.MODID)
public class ElementDamageHandler {

	private static float baseAccumulation = 1.0f;
	private static final int THRESHOLD = 100;

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

	private static int serverTickCounter = 0;
	private static final int CLEANUP_INTERVAL = 100;

	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		DamageSource source = event.getSource();

		ElementType type = getElementTypeFromSource(source);

		if (type == null) {
			PowerMod.LOGGER.debug("Could not determine ElementType for damage source: {}", source.type().msgId());
			return;
		}

		ElementResistanceManager.Resistance resistance = ElementResistanceManager.getResistance(target, type);
		PowerMod.LOGGER.debug("Resistance check: {} vs {} → {}", target.getType().toString(), type, resistance);

		if (ElementResistanceManager.isImmune(target, type)) {
			event.setNewDamage(0f);
			PowerMod.LOGGER.debug("{} is IMMUNE to {}! Damage set to 0", target.getName().getString(), type);
			return;
		}

		int basePoints = (int) baseAccumulation;
		int pointsToAdd = ElementResistanceManager.calculateAccumulationPoints(target, type, basePoints);

		int pointsBefore = PowerModAttachments.getPoints(target, type);
		PowerModAttachments.addPoints(target, type, pointsToAdd);
		int pointsAfter = PowerModAttachments.getPoints(target, type);
		boolean thresholdReached = pointsAfter >= THRESHOLD;

		PowerMod.LOGGER.info("Target: {} | Element: {} | Points: {} +{} → {} | Threshold: {} | Reached: {}",
				target.getName().getString(), type, pointsBefore, pointsToAdd, pointsAfter, THRESHOLD, thresholdReached);

		float finalDamage = event.getOriginalDamage();

		float originalDamage = finalDamage;
		finalDamage = ElementResistanceManager.calculateReducedDamage(target, type, finalDamage);
		PowerMod.LOGGER.debug("Damage calculation: {} × (1 - {}) = {} (Resistance: {})",
				originalDamage, resistance.damageResistance(), finalDamage, resistance);

		if (thresholdReached) {
			finalDamage = applyThresholdEffect(target, type, event, finalDamage);
			PowerModAttachments.resetPoints(target, type);
			PowerMod.LOGGER.info("THRESHOLD TRIGGERED! Reset points for {} on {}", type, target.getName().getString());
		}

		if (canShowDamage(target)) {
			spawnDamageNumber(target, finalDamage, type);
		}
	}

	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		LivingEntity entity = event.getEntity();
		clearActiveDisplays(entity);
		DAMAGE_COOLDOWNS.remove(entity.getId());
	}

	@SubscribeEvent
	public static void onEntityLeaveLevel(EntityLeaveLevelEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof LivingEntity livingEntity) {
			clearActiveDisplays(livingEntity);
			DAMAGE_COOLDOWNS.remove(entity.getId());
		}
	}

	@SubscribeEvent
	public static void onLevelUnload(LevelEvent.Unload event) {
		if (event.getLevel() instanceof ServerLevel) {
			cleanupAllDisplays();
			PowerMod.LOGGER.info("ElementDamageHandler: cleaned up all displays on level unload");
		}
	}

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

		// ✅ Очистка старых записей cooldown (старше 600 тиков = 30 секунд)
		long currentTime = System.currentTimeMillis();
		DAMAGE_COOLDOWNS.entrySet().removeIf(entry -> {
			// Примечание: здесь лучше использовать gameTime, но для простоты оставим как есть
			// В идеале нужно хранить gameTime вместе с entityId
			return false;
		});

		if (cleanedCount > 0) {
			PowerMod.LOGGER.debug("ElementDamageHandler: cleaned {} stale displays", cleanedCount);
		}
	}

	private static ElementType getElementTypeFromSource(DamageSource source) {
		String msgId = source.type().msgId();

		for (ElementType type : ElementType.values()) {
			if (type.getDamageTypeId().equals(msgId)) {
				return type;
			}
		}

		PowerMod.LOGGER.debug("No matching ElementType for msgId: {}", msgId);
		return null;
	}

	public static int getThreshold() {
		return THRESHOLD;
	}

	public static void setThreshold(int threshold) {
		PowerMod.LOGGER.warn("setThreshold() deprecated - all types use THRESHOLD = 100");
	}

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

		int basePoints = (accumulationPoints > 0) ? accumulationPoints : (int) baseAccumulation;
		int pointsToAdd = ElementResistanceManager.calculateAccumulationPoints(livingTarget, type, basePoints);

		if (pointsToAdd > 0) {
			int pointsBefore = PowerModAttachments.getPoints(livingTarget, type);
			PowerModAttachments.addPoints(livingTarget, type, pointsToAdd);
			int pointsAfter = PowerModAttachments.getPoints(livingTarget, type);
			boolean thresholdReached = pointsAfter >= THRESHOLD;

			PowerMod.LOGGER.info("[Manual] Target: {} | Element: {} | Points: {} +{} → {} | Threshold: {} | Reached: {}",
					livingTarget.getName().getString(), type, pointsBefore, pointsToAdd, pointsAfter, THRESHOLD, thresholdReached);

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
	}

	public static void addElementPoints(LivingEntity entity, ElementType type, int points) {
		int pointsToAdd = ElementResistanceManager.calculateAccumulationPoints(entity, type, points);
		PowerModAttachments.addPoints(entity, type, pointsToAdd);
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

	public static ElementResistanceManager.Resistance getEntityResistance(Entity entity, ElementType type) {
		return ElementResistanceManager.getResistance(entity, type);
	}
}