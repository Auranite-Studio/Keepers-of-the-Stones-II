package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;
import com.esmods.keepersofthestonestwo.init.PowerModGameRules;
import com.esmods.keepersofthestonestwo.PowerMod;

public class MagnetElementGetProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!PowerModVariables.MapVariables.get(world).magnet_stone || !world.getLevelData().getGameRules().getBoolean(PowerModGameRules.LIMITED_NUMBER_OF_STONES)) {
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
			PowerModVariables.MapVariables.get(world).syncData(world);
			if (world.getLevelData().getGameRules().getBoolean(PowerModGameRules.LIMIT_OF_STONES_FOR_ONE_PLAYER)) {
				{
					boolean _setval = true;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.selected = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				boolean _setval = false;
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.unlock_keepers_box = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
