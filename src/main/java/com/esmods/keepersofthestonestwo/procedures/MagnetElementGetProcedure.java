package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;
import com.esmods.keepersofthestonestwo.PowerMod;

public class MagnetElementGetProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!PowerModVariables.MapVariables.get(world).magnet_stone || !PowerConfigConfiguration.LIMIT_NUMBER_STONES.get()) {
			PowerMod.queueServerWork(1, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PowerModItems.MAGNET_STONE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
			if (entity instanceof Player _player)
				_player.closeContainer();
			PowerModVariables.MapVariables.get(world).magnet_stone = true;
			PowerModVariables.MapVariables.get(world).markSyncDirty();
			if (PowerConfigConfiguration.ONE_PLAYER_LIMIT_STONES.get()) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.selected = true;
					_vars.markSyncDirty();
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.unlock_keepers_box = false;
				_vars.markSyncDirty();
			}
		}
	}
}