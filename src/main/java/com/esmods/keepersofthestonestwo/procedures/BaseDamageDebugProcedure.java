package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class BaseDamageDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "base_damage: " + Math.round((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).base_damage_by_lvl);
	}
}
