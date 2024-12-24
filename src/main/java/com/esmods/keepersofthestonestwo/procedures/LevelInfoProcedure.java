package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class LevelInfoProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 0 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 9
				? "0" + Math.round(EntityReturnByCardIDProcedure.execute(world).getData(PowerModVariables.PLAYER_VARIABLES).level)
				: "" + Math.round(EntityReturnByCardIDProcedure.execute(world).getData(PowerModVariables.PLAYER_VARIABLES).level);
	}
}
