package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class LevelExpAndMaxDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "current_level_exp: " + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp) + "/" + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp);
	}
}