package com.esmods.keepersofthestonestwo;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ElementResistanceManager {

	private static final Map<EntityType<?>, Map<ElementType, Resistance>> ENTITY_RESISTANCES = new ConcurrentHashMap<>();

	private ElementResistanceManager() {}

	public static void registerResistance(EntityType<?> entityType, Map<ElementType, Resistance> resistanceMap) {
		if (entityType == null || resistanceMap == null) return;

		Map<ElementType, Resistance> existing = ENTITY_RESISTANCES.computeIfAbsent(
				entityType,
				k -> new EnumMap<>(ElementType.class)
		);

		existing.putAll(resistanceMap);

		PowerMod.LOGGER.debug("Registering resistance for: {} → {} (Total: {} elements)",
				entityType.toString(), resistanceMap, existing.size());
	}

	public static Resistance getResistance(Entity entity, ElementType type) {
		if (entity == null || type == null) return new Resistance(0.0f, 0.0f);

		Map<ElementType, Resistance> typeMap = ENTITY_RESISTANCES.get(entity.getType());

		if (typeMap == null) {
			PowerMod.LOGGER.debug("ResistanceMap NOT FOUND for entity type: {}", entity.getType().toString());
			return new Resistance(0.0f, 0.0f);
		}

		PowerMod.LOGGER.debug("ResistanceMap for {} contains {} keys", entity.getType().toString(), typeMap.size());
		typeMap.forEach((key, value) ->
				PowerMod.LOGGER.debug("   └─ Key: {} [class: {}] → {}", key.name(), key.getClass().getName(), value));

		PowerMod.LOGGER.debug("Looking for key: {} [class: {}]", type.name(), type.getClass().getName());

		Resistance res = typeMap.get(type);
		if (res == null) {
			PowerMod.LOGGER.debug("Resistance NOT FOUND for element: {} (Entity: {})", type, entity.getType().toString());
			return new Resistance(0.0f, 0.0f);
		}

		PowerMod.LOGGER.debug("Resistance FOUND: {}", res);
		return res;
	}

	public static int calculateAccumulationPoints(Entity entity, ElementType type, int basePoints) {
		Resistance resistance = getResistance(entity, type);
		float multiplier = Math.max(0f, 1f - resistance.accumulationResistance());
		return Math.round(basePoints * multiplier);
	}

	public static float calculateReducedDamage(Entity entity, ElementType type, float baseDamage) {
		Resistance resistance = getResistance(entity, type);
		float multiplier = Math.max(0f, 1f - resistance.damageResistance());
		return baseDamage * multiplier;
	}

	public static boolean isImmune(Entity entity, ElementType type) {
		Resistance resistance = getResistance(entity, type);
		return resistance.accumulationResistance() >= 1.0f && resistance.damageResistance() >= 1.0f;
	}

	public static void clearAllResistances() {
		ENTITY_RESISTANCES.clear();
	}

	public static int getRegisteredEntityCount() {
		return ENTITY_RESISTANCES.size();
	}

	public static void debugPrintRegistry() {
		PowerMod.LOGGER.info("=== RESISTANCE REGISTRY DEBUG ===");
		PowerMod.LOGGER.info("Total registered entity types: {}", ENTITY_RESISTANCES.size());

		checkAndLog(EntityType.IRON_GOLEM, "IRON_GOLEM");
		checkAndLog(EntityType.BLAZE, "BLAZE");
		checkAndLog(EntityType.SNOW_GOLEM, "SNOW_GOLEM");
		checkAndLog(EntityType.VILLAGER, "VILLAGER");

		PowerMod.LOGGER.info("=== END RESISTANCE REGISTRY DEBUG ===");
	}

	private static void checkAndLog(EntityType<?> type, String name) {
		if (ENTITY_RESISTANCES.containsKey(type)) {
			PowerMod.LOGGER.info("{} found in registry!", name);
			Map<ElementType, Resistance> map = ENTITY_RESISTANCES.get(type);
			if (map != null) {
				map.forEach((elem, res) ->
						PowerMod.LOGGER.info("   └─ {} → {}", elem, res));
			}
		} else {
			PowerMod.LOGGER.warn("{} NOT found in registry!", name);
		}
	}

	public record Resistance(float accumulationResistance, float damageResistance) {

		public static Resistance uniform(float value) {
			return new Resistance(value, value);
		}

		public static Resistance accumulationOnly(float value) {
			return new Resistance(value, 0.0f);
		}

		public static Resistance damageOnly(float value) {
			return new Resistance(0.0f, value);
		}

		public boolean isImmune() {
			return accumulationResistance >= 1.0f && damageResistance >= 1.0f;
		}

		public boolean isWeakness() {
			return accumulationResistance < 0f || damageResistance < 0f;
		}

		public float getAccumulationMultiplier() {
			return Math.max(0f, 1f - accumulationResistance);
		}

		public float getDamageMultiplier() {
			return Math.max(0f, 1f - damageResistance);
		}

		@Override
		public String toString() {
			return String.format("Resistance{acc=%.2f, dmg=%.2f}", accumulationResistance, damageResistance);
		}
	}
}