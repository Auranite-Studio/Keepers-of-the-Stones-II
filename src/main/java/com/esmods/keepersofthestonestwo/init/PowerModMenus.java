/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import java.util.Map;

import com.esmods.keepersofthestonestwo.world.inventory.*;
import com.esmods.keepersofthestonestwo.network.MenuStateUpdateMessage;
import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PowerMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<KeepersBoxGUIPart1Menu>> KEEPERS_BOX_GUI_PART_1 = REGISTRY.register("keepers_box_gui_part_1", () -> IMenuTypeExtension.create(KeepersBoxGUIPart1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KeepersBoxGUIPart2Menu>> KEEPERS_BOX_GUI_PART_2 = REGISTRY.register("keepers_box_gui_part_2", () -> IMenuTypeExtension.create(KeepersBoxGUIPart2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KeepersBoxGUIPart3Menu>> KEEPERS_BOX_GUI_PART_3 = REGISTRY.register("keepers_box_gui_part_3", () -> IMenuTypeExtension.create(KeepersBoxGUIPart3Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KeepersBoxGUIPart4Menu>> KEEPERS_BOX_GUI_PART_4 = REGISTRY.register("keepers_box_gui_part_4", () -> IMenuTypeExtension.create(KeepersBoxGUIPart4Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BatteryChargerGUIMenu>> BATTERY_CHARGER_GUI = REGISTRY.register("battery_charger_gui", () -> IMenuTypeExtension.create(BatteryChargerGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CharacteristicsCardGUIMenu>> CHARACTERISTICS_CARD_GUI = REGISTRY.register("characteristics_card_gui", () -> IMenuTypeExtension.create(CharacteristicsCardGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KeepersBoxGUIPart5Menu>> KEEPERS_BOX_GUI_PART_5 = REGISTRY.register("keepers_box_gui_part_5", () -> IMenuTypeExtension.create(KeepersBoxGUIPart5Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RuneCutterGUIMenu>> RUNE_CUTTER_GUI = REGISTRY.register("rune_cutter_gui", () -> IMenuTypeExtension.create(RuneCutterGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof PowerModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}