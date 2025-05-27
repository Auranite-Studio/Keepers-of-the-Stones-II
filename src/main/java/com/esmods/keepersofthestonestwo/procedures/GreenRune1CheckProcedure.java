package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class GreenRune1CheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.PROTECTION_RUNE.get();
	}
}
