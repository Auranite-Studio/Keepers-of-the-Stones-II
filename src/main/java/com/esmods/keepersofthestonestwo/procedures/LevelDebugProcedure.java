package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class LevelDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "level: " + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).level);
	}
}
