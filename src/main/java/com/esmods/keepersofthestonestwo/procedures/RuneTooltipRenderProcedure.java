package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class RuneTooltipRenderProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String active_rune = "";
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.PROTECTION_RUNE.get()) {
			active_rune = "gui.power.wheel_abilities.tooltip.protection_rune";
		} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.SPIN_RUNE.get()) {
			active_rune = "gui.power.wheel_abilities.tooltip.spin_rune";
		} else {
			active_rune = Component.translatable("gui.power.wheel_abilities.tooltip.rune_not_install").getString();
		}
		return Component.translatable(active_rune).getString();
	}
}
