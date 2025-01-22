package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class GetActiveProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power == true || !(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) && !Minecraft.getInstance().options.hideGui
				&& !entity.getData(PowerModVariables.PLAYER_VARIABLES).debug;
	}
}
