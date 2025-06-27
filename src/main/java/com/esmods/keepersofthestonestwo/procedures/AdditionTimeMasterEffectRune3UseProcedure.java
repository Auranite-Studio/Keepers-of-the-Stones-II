package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class AdditionTimeMasterEffectRune3UseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == ItemStack.EMPTY.getItem()) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.red_rune_slot = itemstack.copy();
				_vars.syncPlayerVariables(entity);
			}
			itemstack.shrink(1);
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration + 600;
				_vars.syncPlayerVariables(entity);
			}
			if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rune_ovelay_display = 100;
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == ItemStack.EMPTY.getItem())) {
			RedSlotOnRemoveProcedure.execute(entity);
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == ItemStack.EMPTY.getItem()) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.red_rune_slot = itemstack.copy();
					_vars.syncPlayerVariables(entity);
				}
				itemstack.shrink(1);
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration + 600;
					_vars.syncPlayerVariables(entity);
				}
				if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.rune_ovelay_display = 100;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}