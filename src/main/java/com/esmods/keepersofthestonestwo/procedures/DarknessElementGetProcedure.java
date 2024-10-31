package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;
import com.esmods.keepersofthestonestwo.init.PowerModGameRules;
import com.esmods.keepersofthestonestwo.PowerMod;

public class DarknessElementGetProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!PowerModVariables.MapVariables.get(world).darkness_stone || !world.getLevelData().getGameRules().getBoolean(PowerModGameRules.LIMITED_NUMBER_OF_STONES)) {
			PowerMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PowerModItems.DARKNESS_STONE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
			if (entity instanceof Player _player)
				_player.closeContainer();
			PowerModVariables.MapVariables.get(world).darkness_stone = true;
			PowerModVariables.MapVariables.get(world).syncData(world);
			if (world.getLevelData().getGameRules().getBoolean(PowerModGameRules.LIMIT_OF_STONES_FOR_ONE_PLAYER)) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.selected = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.unlock_keepers_box = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
