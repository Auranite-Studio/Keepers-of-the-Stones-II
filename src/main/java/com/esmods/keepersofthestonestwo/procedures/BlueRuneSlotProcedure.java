package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber
public class BlueRuneSlotProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).setup_rune_to_blue_slot_event) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.blue_rune_slot = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()).copy();
					_vars.syncPlayerVariables(entity);
				}
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power + 10;
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.blue_rune_slot = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()).copy();
					_vars.syncPlayerVariables(entity);
				}
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power + 15;
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.blue_rune_slot = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()).copy();
					_vars.syncPlayerVariables(entity);
				}
				if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power + 20;
					_vars.syncPlayerVariables(entity);
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.setup_rune_to_blue_slot_event = false;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).remove_rune_to_blue_slot_event) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.blue_rune_slot = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 10;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.blue_rune_slot = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 15;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.blue_rune_slot = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 20;
					_vars.syncPlayerVariables(entity);
				}
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.remove_rune_to_blue_slot_event = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
