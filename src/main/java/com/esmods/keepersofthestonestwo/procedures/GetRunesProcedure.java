package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class GetRunesProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power == true || entity.getData(PowerModVariables.PLAYER_VARIABLES).rune_ovelay_display > 0) && !Minecraft.getInstance().options.hideGui
				&& !entity.getData(PowerModVariables.PLAYER_VARIABLES).debug;
	}
}
