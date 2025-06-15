package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class StarPointsDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "star_points: " + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).power);
	}
}