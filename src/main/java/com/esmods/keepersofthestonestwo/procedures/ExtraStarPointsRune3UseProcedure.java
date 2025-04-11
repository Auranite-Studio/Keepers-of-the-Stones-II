package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.PowerMod;

public class ExtraStarPointsRune3UseProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == ItemStack.EMPTY.getItem()) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.setup_rune_to_blue_slot_event = true;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.remove_rune_to_blue_slot_event = true;
					_vars.syncPlayerVariables(entity);
				}
				PowerMod.queueServerWork(1, () -> {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.setup_rune_to_blue_slot_event = true;
						_vars.syncPlayerVariables(entity);
					}
				});
			}
		}
	}
}
