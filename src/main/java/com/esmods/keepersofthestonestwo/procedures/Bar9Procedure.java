package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class Bar9Procedure {
	public static boolean execute(LevelAccessor world) {
		if (EntityReturnByCardIDProcedure.execute(world).getData(PowerModVariables.PLAYER_VARIABLES).level_exp / EntityReturnByCardIDProcedure.execute(world).getData(PowerModVariables.PLAYER_VARIABLES).level >= 72) {
			return true;
		}
		return false;
	}
}
