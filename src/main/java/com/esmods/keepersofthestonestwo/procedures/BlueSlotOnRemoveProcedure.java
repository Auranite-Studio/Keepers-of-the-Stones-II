package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class BlueSlotOnRemoveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.blue_rune_slot = ItemStack.EMPTY.copy();
				_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 10;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.blue_rune_slot = ItemStack.EMPTY.copy();
				_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 15;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.blue_rune_slot = ItemStack.EMPTY.copy();
				_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 20;
				_vars.markSyncDirty();
			}
		}
	}
}