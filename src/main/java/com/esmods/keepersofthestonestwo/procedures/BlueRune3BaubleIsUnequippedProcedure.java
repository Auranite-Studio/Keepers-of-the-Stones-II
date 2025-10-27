package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class BlueRune3BaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 20;
			_vars.blue_rune_slot = ItemStack.EMPTY.copy();
			_vars.markSyncDirty();
		}
	}
}