
package com.esmods.keepersofthestonestwo;

import net.minecraft.world.entity.EntityType;

import java.util.EnumMap;
import java.util.Map;

public class ElementResistanceRegistry {

    private ElementResistanceRegistry() {}

    public static void init() {
        PowerMod.LOGGER.info("Initializing Element Resistance Registry...");
        PowerMod.LOGGER.info("ElementType.FIRE.getDamageTypeId() = {}", ElementType.FIRE.getDamageTypeId());
        PowerMod.LOGGER.info("ElementType.PHYSICAL.getDamageTypeId() = {}", ElementType.PHYSICAL.getDamageTypeId());

        try {
            registerFireResistances();
            registerPhysicalResistances();

            PowerMod.LOGGER.info("Element Resistance Registry initialized! Total: {} entities",
                    ElementResistanceManager.getRegisteredEntityCount());
        } catch (Exception e) {
            PowerMod.LOGGER.error("Failed to initialize Element Resistance Registry!", e);
            e.printStackTrace();
        }
    }

    private static void registerFireResistances() {
        PowerMod.LOGGER.debug("Registering FIRE resistances...");

        registerUniform(ElementType.FIRE, 1.0f, 1.0f,
                EntityType.BLAZE,
                EntityType.WITHER_SKELETON,
                EntityType.MAGMA_CUBE,
                EntityType.GHAST,
                EntityType.ZOGLIN,
                EntityType.STRIDER,
                EntityType.ENDER_DRAGON,
                EntityType.WITHER
        );

        registerUniform(ElementType.FIRE, -0.25f, -0.25f,
                EntityType.SNOW_GOLEM,
                EntityType.POLAR_BEAR
        );

        registerUniform(ElementType.FIRE, 0.5f, 0.5f,
                EntityType.HOGLIN,
                EntityType.IRON_GOLEM
        );
    }

    private static void registerPhysicalResistances() {
        PowerMod.LOGGER.debug("Registering PHYSICAL resistances...");

        registerUniform(ElementType.PHYSICAL, 1.0f, 1.0f,
                EntityType.ARMOR_STAND,
                EntityType.END_CRYSTAL,
                EntityType.PAINTING,
                EntityType.ITEM_FRAME,
                EntityType.LEASH_KNOT
        );

        registerUniform(ElementType.PHYSICAL, 0.5f, 0.5f,
                EntityType.IRON_GOLEM,
                EntityType.ZOGLIN,
                EntityType.RAVAGER,
                EntityType.WARDEN
        );

        registerUniform(ElementType.PHYSICAL, 0.25f, 0.25f,
                EntityType.TURTLE,
                EntityType.SHULKER
        );

        registerCustom(ElementType.PHYSICAL, 0.0f, -0.5f,
                EntityType.VILLAGER,
                EntityType.AXOLOTL,
                EntityType.BAT,
                EntityType.CAT,
                EntityType.OCELOT,
                EntityType.CHICKEN,
                EntityType.RABBIT
        );
    }

    @SuppressWarnings("unused")
    private static void registerWaterResistances() {
    }

    @SuppressWarnings("unused")
    private static void registerLightningResistances() {
    }

    @SafeVarargs
    private static void registerUniform(ElementType elementType, float resistance, EntityType<?>... entityTypes) {
        registerUniform(elementType, resistance, resistance, entityTypes);
    }

    @SafeVarargs
    private static void registerUniform(ElementType elementType, float accumulationResistance, float damageResistance, EntityType<?>... entityTypes) {
        for (EntityType<?> type : entityTypes) {
            if (type == null) continue;
            Map<ElementType, ElementResistanceManager.Resistance> map = new EnumMap<>(ElementType.class);
            map.put(elementType, new ElementResistanceManager.Resistance(accumulationResistance, damageResistance));
            ElementResistanceManager.registerResistance(type, map);
        }
    }

    @SafeVarargs
    private static void registerCustom(ElementType elementType, float accumulationResistance, float damageResistance, EntityType<?>... entityTypes) {
        for (EntityType<?> type : entityTypes) {
            if (type == null) continue;
            Map<ElementType, ElementResistanceManager.Resistance> map = new EnumMap<>(ElementType.class);
            map.put(elementType, new ElementResistanceManager.Resistance(accumulationResistance, damageResistance));
            ElementResistanceManager.registerResistance(type, map);
        }
    }

    public static void registerSingle(EntityType<?> entityType, ElementType elementType,
                                      float accumulationResistance, float damageResistance) {
        if (entityType == null || elementType == null) return;
        Map<ElementType, ElementResistanceManager.Resistance> map = new EnumMap<>(ElementType.class);
        map.put(elementType, new ElementResistanceManager.Resistance(accumulationResistance, damageResistance));
        ElementResistanceManager.registerResistance(entityType, map);
    }

    public static void registerSingleUniform(EntityType<?> entityType, ElementType elementType, float resistance) {
        registerSingle(entityType, elementType, resistance, resistance);
    }

    public static void registerMultiple(EntityType<?> entityType, Map<ElementType, ElementResistanceManager.Resistance> resistanceMap) {
        if (entityType == null || resistanceMap == null || resistanceMap.isEmpty()) return;
        ElementResistanceManager.registerResistance(entityType, new EnumMap<>(resistanceMap));
    }

    public static boolean hasResistances(EntityType<?> entityType) {
        return entityType != null && ElementResistanceManager.getRegisteredEntityCount() > 0;
    }
}