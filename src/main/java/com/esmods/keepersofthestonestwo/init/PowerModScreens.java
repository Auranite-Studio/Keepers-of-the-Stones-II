
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.esmods.keepersofthestonestwo.client.gui.WheelAbiltiesGoldenDustScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilityDarknessScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesWaterScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesVacuumScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesTornadoScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesTimeScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesTeleportationScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesTechnologyScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesSunScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesSpiritScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesSpeedScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesSpaceScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesSoundScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesSmokeScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesShadowScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesSandScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesRainScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesPoisonScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesPlantsScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesPlagueScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesOceanScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMusicScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMushroomsScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMoonScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMistScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMindScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMetalScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMercuryScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesMagnetScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesLightningScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesLightScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesLavaScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesIceScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesGravityScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesFormScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesFireScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesExplosionScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesEtherScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesEnergyScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesEarthScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesDestructionScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesCrystalScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesCreationScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesBlueFlameScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesBloodScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesAnimalsScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesAmberScreen;
import com.esmods.keepersofthestonestwo.client.gui.WheelAbilitiesAirScreen;
import com.esmods.keepersofthestonestwo.client.gui.KeepersBoxGUIPart4Screen;
import com.esmods.keepersofthestonestwo.client.gui.KeepersBoxGUIPart3Screen;
import com.esmods.keepersofthestonestwo.client.gui.KeepersBoxGUIPart2Screen;
import com.esmods.keepersofthestonestwo.client.gui.KeepersBoxGUIPart1Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PowerModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_FIRE.get(), WheelAbilitiesFireScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_AIR.get(), WheelAbilitiesAirScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_WATER.get(), WheelAbilitiesWaterScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_EARTH.get(), WheelAbilitiesEarthScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_ETHER.get(), WheelAbilitiesEtherScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_LIGHTNING.get(), WheelAbilitiesLightningScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SOUND.get(), WheelAbilitiesSoundScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_CRYSTAL.get(), WheelAbilitiesCrystalScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_LAVA.get(), WheelAbilitiesLavaScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_ICE.get(), WheelAbilitiesIceScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_RAIN.get(), WheelAbilitiesRainScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_TORNADO.get(), WheelAbilitiesTornadoScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_OCEAN.get(), WheelAbilitiesOceanScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_PLANTS.get(), WheelAbilitiesPlantsScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_ANIMALS.get(), WheelAbilitiesAnimalsScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_METAL.get(), WheelAbilitiesMetalScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_LIGHT.get(), WheelAbilitiesLightScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SHADOW.get(), WheelAbilitiesShadowScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_VACUUM.get(), WheelAbilitiesVacuumScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_ENERGY.get(), WheelAbilitiesEnergyScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SUN.get(), WheelAbilitiesSunScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_MOON.get(), WheelAbilitiesMoonScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SPACE.get(), WheelAbilitiesSpaceScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_TIME.get(), WheelAbilitiesTimeScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_CREATION.get(), WheelAbilitiesCreationScreen::new);
			MenuScreens.register(PowerModMenus.KEEPERS_BOX_GUI_PART_1.get(), KeepersBoxGUIPart1Screen::new);
			MenuScreens.register(PowerModMenus.KEEPERS_BOX_GUI_PART_2.get(), KeepersBoxGUIPart2Screen::new);
			MenuScreens.register(PowerModMenus.KEEPERS_BOX_GUI_PART_3.get(), KeepersBoxGUIPart3Screen::new);
			MenuScreens.register(PowerModMenus.KEEPERS_BOX_GUI_PART_4.get(), KeepersBoxGUIPart4Screen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_DESTRUCTION.get(), WheelAbilitiesDestructionScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_BLOOD.get(), WheelAbilitiesBloodScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_TECHNOLOGY.get(), WheelAbilitiesTechnologyScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_TELEPORTATION.get(), WheelAbilitiesTeleportationScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_EXPLOSION.get(), WheelAbilitiesExplosionScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_AMBER.get(), WheelAbilitiesAmberScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_MIST.get(), WheelAbilitiesMistScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SAND.get(), WheelAbilitiesSandScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SPEED.get(), WheelAbilitiesSpeedScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_POISON.get(), WheelAbilitiesPoisonScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_MAGNET.get(), WheelAbilitiesMagnetScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_MUSHROOMS.get(), WheelAbilitiesMushroomsScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_MERCURY.get(), WheelAbilitiesMercuryScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_MUSIC.get(), WheelAbilitiesMusicScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_PLAGUE.get(), WheelAbilitiesPlagueScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_BLUE_FLAME.get(), WheelAbilitiesBlueFlameScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_GRAVITY.get(), WheelAbilitiesGravityScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SMOKE.get(), WheelAbilitiesSmokeScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_SPIRIT.get(), WheelAbilitiesSpiritScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_FORM.get(), WheelAbilitiesFormScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITIES_MIND.get(), WheelAbilitiesMindScreen::new);
			MenuScreens.register(PowerModMenus.BATTERY_CHARGER_GUI.get(), BatteryChargerGUIScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILTIES_GOLDEN_DUST.get(), WheelAbiltiesGoldenDustScreen::new);
			MenuScreens.register(PowerModMenus.WHEEL_ABILITY_DARKNESS.get(), WheelAbilityDarknessScreen::new);
		});
	}
}
