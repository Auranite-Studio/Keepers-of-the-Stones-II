package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class GetWheelTwoProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("0");
	}
}