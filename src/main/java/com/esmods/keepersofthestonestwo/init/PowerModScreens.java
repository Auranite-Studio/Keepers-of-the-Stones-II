
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

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
import com.esmods.keepersofthestonestwo.client.gui.BatteryChargerGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PowerModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PowerModMenus.WHEEL_ABILITIES_FIRE.get(), WheelAbilitiesFireScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_AIR.get(), WheelAbilitiesAirScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_WATER.get(), WheelAbilitiesWaterScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_EARTH.get(), WheelAbilitiesEarthScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_ETHER.get(), WheelAbilitiesEtherScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_LIGHTNING.get(), WheelAbilitiesLightningScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SOUND.get(), WheelAbilitiesSoundScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_CRYSTAL.get(), WheelAbilitiesCrystalScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_LAVA.get(), WheelAbilitiesLavaScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_ICE.get(), WheelAbilitiesIceScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_RAIN.get(), WheelAbilitiesRainScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_TORNADO.get(), WheelAbilitiesTornadoScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_OCEAN.get(), WheelAbilitiesOceanScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_PLANTS.get(), WheelAbilitiesPlantsScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_ANIMALS.get(), WheelAbilitiesAnimalsScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_METAL.get(), WheelAbilitiesMetalScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_LIGHT.get(), WheelAbilitiesLightScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SHADOW.get(), WheelAbilitiesShadowScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_VACUUM.get(), WheelAbilitiesVacuumScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_ENERGY.get(), WheelAbilitiesEnergyScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SUN.get(), WheelAbilitiesSunScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_MOON.get(), WheelAbilitiesMoonScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SPACE.get(), WheelAbilitiesSpaceScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_TIME.get(), WheelAbilitiesTimeScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_CREATION.get(), WheelAbilitiesCreationScreen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_1.get(), KeepersBoxGUIPart1Screen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_2.get(), KeepersBoxGUIPart2Screen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_3.get(), KeepersBoxGUIPart3Screen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_4.get(), KeepersBoxGUIPart4Screen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_DESTRUCTION.get(), WheelAbilitiesDestructionScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_BLOOD.get(), WheelAbilitiesBloodScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_TECHNOLOGY.get(), WheelAbilitiesTechnologyScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_TELEPORTATION.get(), WheelAbilitiesTeleportationScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_EXPLOSION.get(), WheelAbilitiesExplosionScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_AMBER.get(), WheelAbilitiesAmberScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_MIST.get(), WheelAbilitiesMistScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SAND.get(), WheelAbilitiesSandScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SPEED.get(), WheelAbilitiesSpeedScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_POISON.get(), WheelAbilitiesPoisonScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_MAGNET.get(), WheelAbilitiesMagnetScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_MUSHROOMS.get(), WheelAbilitiesMushroomsScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_MERCURY.get(), WheelAbilitiesMercuryScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_MUSIC.get(), WheelAbilitiesMusicScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_PLAGUE.get(), WheelAbilitiesPlagueScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_BLUE_FLAME.get(), WheelAbilitiesBlueFlameScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_GRAVITY.get(), WheelAbilitiesGravityScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SMOKE.get(), WheelAbilitiesSmokeScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SPIRIT.get(), WheelAbilitiesSpiritScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_FORM.get(), WheelAbilitiesFormScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_MIND.get(), WheelAbilitiesMindScreen::new);
		event.register(PowerModMenus.BATTERY_CHARGER_GUI.get(), BatteryChargerGUIScreen::new);
		event.register(PowerModMenus.WHEEL_ABILTIES_GOLDEN_DUST.get(), WheelAbiltiesGoldenDustScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITY_DARKNESS.get(), WheelAbilityDarknessScreen::new);
	}
}
