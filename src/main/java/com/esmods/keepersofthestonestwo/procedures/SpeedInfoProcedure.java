package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class SpeedInfoProcedure {
	public static String execute(LevelAccessor world) {
		return "" + Math.round(EntityReturnByCardIDProcedure.execute(world).getData(PowerModVariables.PLAYER_VARIABLES).speed_char + 1);
	}
}
