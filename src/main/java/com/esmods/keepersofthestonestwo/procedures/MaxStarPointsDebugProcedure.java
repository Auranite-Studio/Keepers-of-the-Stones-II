package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class MaxStarPointsDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "max_star_points: " + new java.text.DecimalFormat("###").format(entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power);
	}
}