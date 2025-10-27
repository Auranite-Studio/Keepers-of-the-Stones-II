package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class RedRune2BaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.recharge_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer + 60;
			_vars.red_rune_slot = ItemStack.EMPTY.copy();
			_vars.markSyncDirty();
		}
	}
}