package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModItems;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * 🔹 ОБРАБОТЧИК РЕГИСТРАЦИИ ЭЛЕМЕНТАЛЬНОГО ОРУЖИЯ 🔹
 *
 * Вызывается при инициализации мода для регистрации существующих предметов.
 */
@EventBusSubscriber
public class ElementalWeaponRegistrationHandler {

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PowerMod.LOGGER.info("⚔️ Registering elemental weapons...");

            // === 🔥 ОГНЕННОЕ ОРУЖИЕ ===
            registerFireWeapons();

            // === ⚔️ ФИЗИЧЕСКОЕ ОРУЖИЕ (усиленное) ===
            registerPhysicalWeapons();

            PowerMod.LOGGER.info("✅ Elemental weapon registration complete! Total: {}",
                    ElementalWeaponRegistry.getRegisteredCount());
        });
    }

    private static void registerFireWeapons() {
        ElementalWeaponUtils.registerVanillaItem(Items.BLAZE_ROD, ElementType.FIRE, 10f);
        ElementalWeaponUtils.registerVanillaItem(PowerModItems.FIRE_SWORD.get(), ElementType.FIRE, 12.5f);

    }

    private static void registerPhysicalWeapons() {
        ElementalWeaponUtils.registerVanillaItem(Items.NETHERITE_SWORD, ElementType.PHYSICAL, 15f);
        ElementalWeaponUtils.registerVanillaItem(Items.DIAMOND_SWORD, ElementType.PHYSICAL, 10f);
        ElementalWeaponUtils.registerVanillaItem(Items.IRON_SWORD, ElementType.PHYSICAL, 7f);
        ElementalWeaponUtils.registerVanillaItem(Items.STONE_SWORD, ElementType.PHYSICAL, 4f);
        ElementalWeaponUtils.registerVanillaItem(Items.WOODEN_AXE, ElementType.PHYSICAL, 2f);

        ElementalWeaponUtils.registerVanillaItem(Items.NETHERITE_AXE, ElementType.PHYSICAL, 20f);
        ElementalWeaponUtils.registerVanillaItem(Items.DIAMOND_AXE, ElementType.PHYSICAL, 15f);
        ElementalWeaponUtils.registerVanillaItem(Items.IRON_AXE, ElementType.PHYSICAL, 10f);
        ElementalWeaponUtils.registerVanillaItem(Items.STONE_AXE, ElementType.PHYSICAL, 5f);
        ElementalWeaponUtils.registerVanillaItem(Items.WOODEN_AXE, ElementType.PHYSICAL, 3f);
    }
}