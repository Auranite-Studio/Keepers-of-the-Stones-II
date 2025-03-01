package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class GetStarPointsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + (entity.getData(PowerModVariables.PLAYER_VARIABLES).power > 9999 ? "\u221E" : Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).power));
	}
}
