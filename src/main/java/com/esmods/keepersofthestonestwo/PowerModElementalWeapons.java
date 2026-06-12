package com.esmods.keepersofthestonestwo;

import com.auranite.abloom.AbloomMod;
import com.auranite.abloom.ElementType;
import com.auranite.abloom.ElementalWeaponRegistry;
import com.auranite.abloom.ElementalWeaponUtils;
import com.esmods.keepersofthestonestwo.init.PowerModItems;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber
public class PowerModElementalWeapons {

	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AbloomMod.LOGGER.info("⚔️ Registering elemental weapons...");

			registerFireWeapons();
			registerPhysicalWeapons();
			registerWindWeapons();
			registerWaterWeapons();
			registerEarthWeapons();
			registerIceWeapons();
			registerElectricWeapons();
			registerEnergyWeapons();
			registerNaturalWeapons();
			registerQuantumWeapons();
			registerEtherWeapons();
			registerLightWeapons();
			registerShadowWeapons();

			AbloomMod.LOGGER.info("✅ Elemental weapon registration complete! Total: {}",
					ElementalWeaponRegistry.getRegisteredCount());
		});
	}

	private static void registerFireWeapons() {
		ElementalWeaponUtils.registerItem(PowerModItems.FIRE_SWORD.get(), ElementType.FIRE, 5f);
	}

	private static void registerPhysicalWeapons() {
	}

	private static void registerWindWeapons() {
		ElementalWeaponUtils.registerItem(PowerModItems.AIR_RAPIER.get(), ElementType.WIND, 10f);
	}

	private static void registerWaterWeapons() {
		ElementalWeaponUtils.registerItem(PowerModItems.WATER_KATANA.get(), ElementType.WATER, 5f);
	}

	private static void registerEarthWeapons() {
		ElementalWeaponUtils.registerItem(PowerModItems.EARTH_HAMMER.get(), ElementType.EARTH, 5f);
	}
	private static void registerIceWeapons() {
		ElementalWeaponUtils.registerItem(PowerModItems.ICE_SPEAR.get(), ElementType.ICE, 5f);
	}
	private static void registerElectricWeapons() {
	}
	private static void registerEnergyWeapons() {
	}
	private static void registerNaturalWeapons() {
	}
	private static void registerQuantumWeapons() {
	}

	private static void registerEtherWeapons() {
		ElementalWeaponUtils.registerItem(PowerModItems.ETHER_GLAIVE.get(), ElementType.ETHER, 10f);

	}

	private static void registerLightWeapons() {
	}

	private static void registerShadowWeapons() {
	}
}
