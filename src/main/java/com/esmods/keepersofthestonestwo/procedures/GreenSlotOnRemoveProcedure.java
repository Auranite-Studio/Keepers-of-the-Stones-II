package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class GreenSlotOnRemoveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.SPIN_RUNE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.SPIN_RUNE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.green_rune_slot = ItemStack.EMPTY.copy();
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.DODGING_RUNE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.DODGING_RUNE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.green_rune_slot = ItemStack.EMPTY.copy();
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.INVISIBILITY_RUNE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.INVISIBILITY_RUNE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.green_rune_slot = ItemStack.EMPTY.copy();
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.HEALING_RUNE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.HEALING_RUNE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.green_rune_slot = ItemStack.EMPTY.copy();
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.PROTECTION_RUNE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.PROTECTION_RUNE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.green_rune_slot = ItemStack.EMPTY.copy();
				_vars.markSyncDirty();
			}
		}
	}
}