package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class BaseDamageDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "base_damage: " + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl);
	}
}