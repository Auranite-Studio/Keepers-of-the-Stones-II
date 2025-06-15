package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class ElementsActiveDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "elements_active: " + entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first + "/" + entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second + "/"
				+ entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third;
	}
}