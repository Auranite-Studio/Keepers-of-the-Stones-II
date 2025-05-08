package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class RedSlotOnRemoveProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.red_rune_slot = ItemStack.EMPTY.copy();
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.recharge_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer + 30;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.red_rune_slot = ItemStack.EMPTY.copy();
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.recharge_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer + 60;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_3.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_3.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.red_rune_slot = ItemStack.EMPTY.copy();
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.recharge_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer + 150;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.red_rune_slot = ItemStack.EMPTY.copy();
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration - 150;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.red_rune_slot = ItemStack.EMPTY.copy();
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration - 300;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_3.get()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_3.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.red_rune_slot = ItemStack.EMPTY.copy();
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration - 600;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
