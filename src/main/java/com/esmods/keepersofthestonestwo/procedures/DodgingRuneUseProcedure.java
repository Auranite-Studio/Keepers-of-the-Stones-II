package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class DodgingRuneUseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == ItemStack.EMPTY.getItem()) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.green_rune_slot = itemstack.copy();
				_vars.markSyncDirty();
			}
			itemstack.shrink(1);
			if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rune_ovelay_display = 100;
					_vars.markSyncDirty();
				}
			}
		} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == ItemStack.EMPTY.getItem())) {
			GreenSlotOnRemoveProcedure.execute(entity);
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == ItemStack.EMPTY.getItem()) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.green_rune_slot = itemstack.copy();
					_vars.markSyncDirty();
				}
				itemstack.shrink(1);
				if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.rune_ovelay_display = 100;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}