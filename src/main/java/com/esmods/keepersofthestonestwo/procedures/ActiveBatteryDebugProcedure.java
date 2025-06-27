package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class ActiveBatteryDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "active_battery: " + entity.getData(PowerModVariables.PLAYER_VARIABLES).active_battery;
	}
}