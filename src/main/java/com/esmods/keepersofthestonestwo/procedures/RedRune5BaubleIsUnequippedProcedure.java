package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class RedRune5BaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration - 300;
			_vars.red_rune_slot = ItemStack.EMPTY.copy();
			_vars.markSyncDirty();
		}
	}
}