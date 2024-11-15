package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class StarPointsRegTimerDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "star_points_reg_timer: " + Math.round((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).powerTimer);
	}
}
