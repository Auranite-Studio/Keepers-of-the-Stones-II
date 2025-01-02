package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class AbilityBlockedDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "ability_blocked: " + (entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).ability_block;
	}
}
