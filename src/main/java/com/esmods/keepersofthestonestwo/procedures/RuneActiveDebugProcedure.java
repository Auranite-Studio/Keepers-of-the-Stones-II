package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class RuneActiveDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "runes_active: " + BuiltInRegistries.ITEM.getKey(entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem()).toString() + "/"
				+ BuiltInRegistries.ITEM.getKey(entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem()).toString() + "/"
				+ BuiltInRegistries.ITEM.getKey(entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem()).toString();
	}
}
