package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class RuneTooltipRenderProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String active_rune = "";
		if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == ItemStack.EMPTY.getItem())) {
			active_rune = "gui.power.wheel_abilities.tooltip." + BuiltInRegistries.ITEM.getKey(entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem()).toString();
		} else {
			active_rune = Component.translatable("gui.power.wheel_abilities.tooltip.rune_not_install").getString();
		}
		return Component.translatable(active_rune).getString();
	}
}