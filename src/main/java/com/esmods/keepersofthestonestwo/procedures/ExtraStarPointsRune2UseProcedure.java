package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class ExtraStarPointsRune2UseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power + 15;
				_vars.syncPlayerVariables(entity);
			}
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				itemstack.shrink(1);
			}
		}
	}
}
