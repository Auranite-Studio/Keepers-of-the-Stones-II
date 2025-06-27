package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class MergersNumberDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "mergers_number: " + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers);
	}
}