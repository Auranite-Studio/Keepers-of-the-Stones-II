package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

public class TeleportationStoneCheckProcedure {
	public static boolean execute(LevelAccessor world) {
		if (PowerConfigConfiguration.LIMIT_NUMBER_STONES.get() == true) {
			if (PowerModVariables.MapVariables.get(world).teleportation_stone == false) {
				return true;
			}
		} else if (PowerConfigConfiguration.LIMIT_NUMBER_STONES.get() == false) {
			return true;
		}
		return false;
	}
}
