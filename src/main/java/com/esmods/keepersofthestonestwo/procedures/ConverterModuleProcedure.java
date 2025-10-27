package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@EventBusSubscriber
public class ConverterModuleProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level == 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level = 1;
					_vars.resistance_char = 0;
					_vars.jump_char = 1;
					_vars.speed_char = 1;
					_vars.haste_char = -1;
					_vars.markSyncDirty();
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp == 0) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.max_level_exp = 100;
						_vars.markSyncDirty();
					}
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl == 0 || entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl == 13.5) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.base_damage_by_lvl = 6;
						_vars.markSyncDirty();
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "D";
					_vars.markSyncDirty();
				}
			}
		} else {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl != 13.5) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.base_damage_by_lvl = 13.5;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level != 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level = 0;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp != 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level_exp = 0;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp != 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_level_exp = 0;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).resistance_char != 2) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 2;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).speed_char != 2) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.speed_char = 2;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).jump_char != 2) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.jump_char = 2;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).haste_char != -1) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = -1;
					_vars.markSyncDirty();
				}
			}
			if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).rank).equals("0")) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "0";
					_vars.markSyncDirty();
				}
			}
		}
		if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).conv_to_new_rune_system) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.blue_rune_slot = ItemStack.EMPTY.copy();
				_vars.red_rune_slot = ItemStack.EMPTY.copy();
				_vars.green_rune_slot = ItemStack.EMPTY.copy();
				_vars.max_power = 100;
				_vars.recharge_timer = 300;
				_vars.master_effect_duration = 600;
				_vars.conv_to_new_rune_system = true;
				_vars.markSyncDirty();
			}
		}
		PowerModVariables.MapVariables.get(world).cpapi_ver = 28;
		PowerModVariables.MapVariables.get(world).markSyncDirty();
	}
}