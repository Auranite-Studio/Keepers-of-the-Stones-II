package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class SelectedAttackDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "selected_ability: " + entity.getData(PowerModVariables.PLAYER_VARIABLES).ability;
	}
}