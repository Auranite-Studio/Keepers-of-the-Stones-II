package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class BlueRune2CheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get();
	}
}