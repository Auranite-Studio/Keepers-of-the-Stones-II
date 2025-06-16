package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class RedRune3CheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_3.get();
	}
}