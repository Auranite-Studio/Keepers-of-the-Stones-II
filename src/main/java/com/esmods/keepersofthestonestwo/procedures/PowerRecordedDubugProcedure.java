package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class PowerRecordedDubugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "power_recorded: " + entity.getData(PowerModVariables.PLAYER_VARIABLES).power_recorded;
	}
}