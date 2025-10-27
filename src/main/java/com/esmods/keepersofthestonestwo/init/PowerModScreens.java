/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.esmods.keepersofthestonestwo.client.gui.*;

@EventBusSubscriber(Dist.CLIENT)
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
		event.register(PowerModMenus.CHARACTERISTICS_CARD_GUI.get(), CharacteristicsCardGUIScreen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_5.get(), KeepersBoxGUIPart5Screen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_HEAT.get(), WheelAbilitiesHeatScreen::new);
		event.register(PowerModMenus.WHEEL_ABILITIES_SHOCKWAVE.get(), WheelAbilitiesShockwaveScreen::new);
		event.register(PowerModMenus.RUNE_CUTTER_GUI.get(), RuneCutterGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}