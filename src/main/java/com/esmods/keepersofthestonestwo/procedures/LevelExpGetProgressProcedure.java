package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class LevelExpGetProgressProcedure {
	public static double execute(LevelAccessor world) {
		return EntityReturnByCardIDProcedure.execute(world).getData(PowerModVariables.PLAYER_VARIABLES).level_exp / EntityReturnByCardIDProcedure.execute(world).getData(PowerModVariables.PLAYER_VARIABLES).level;
	}
}
