package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class ActivePowerDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "active_power: " + entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power;
	}
}