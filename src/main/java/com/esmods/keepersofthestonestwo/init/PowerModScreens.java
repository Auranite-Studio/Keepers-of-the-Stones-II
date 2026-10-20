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
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_1.get(), KeepersBoxGUIPart1Screen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_2.get(), KeepersBoxGUIPart2Screen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_3.get(), KeepersBoxGUIPart3Screen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_4.get(), KeepersBoxGUIPart4Screen::new);
		event.register(PowerModMenus.BATTERY_CHARGER_GUI.get(), BatteryChargerGUIScreen::new);
		event.register(PowerModMenus.CHARACTERISTICS_CARD_GUI.get(), CharacteristicsCardGUIScreen::new);
		event.register(PowerModMenus.KEEPERS_BOX_GUI_PART_5.get(), KeepersBoxGUIPart5Screen::new);
		event.register(PowerModMenus.RUNE_CUTTER_GUI.get(), RuneCutterGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}