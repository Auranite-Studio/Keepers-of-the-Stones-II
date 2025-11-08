package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class EthernalProgressBarIntProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double particleRadius = 0;
		double particleAmount = 0;
		return entity.getData(PowerModVariables.PLAYER_VARIABLES).ethernal_curse_points / (entity.getData(PowerModVariables.PLAYER_VARIABLES).max_ethernal_curse_points / 100);
	}
}