package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class RuneTooltipRenderProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == ItemStack.EMPTY.getItem()) {
			return Component.translatable("gui.power.wheel_abilities.tooltip.rune_not_install").getString();
		}
		return Component.translatable("gui.power.wheel_abilities.tooltip.protection_rune").getString();
	}
}
