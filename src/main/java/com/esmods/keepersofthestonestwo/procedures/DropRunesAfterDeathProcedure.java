package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber
public class DropRunesAfterDeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack copySlot = ItemStack.EMPTY;
		if (entity instanceof Player) {
			if (!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
				if (!(ItemStack.EMPTY.getItem() == entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.getItem())) {
					copySlot = entity.getData(PowerModVariables.PLAYER_VARIABLES).blue_rune_slot.copy();
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.blue_rune_slot = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (copySlot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 10;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (copySlot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 15;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (copySlot.getItem() == PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.max_power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power - 20;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, copySlot);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (!(ItemStack.EMPTY.getItem() == entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem())) {
					copySlot = entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.copy();
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.red_rune_slot = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.recharge_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer + 30;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.recharge_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer + 60;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_3.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.recharge_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer + 180;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration - 180;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration - 300;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (entity.getData(PowerModVariables.PLAYER_VARIABLES).red_rune_slot.getItem() == PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_3.get()) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.master_effect_duration = entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration - 600;
							_vars.syncPlayerVariables(entity);
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, copySlot);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (!(ItemStack.EMPTY.getItem() == entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem())) {
					copySlot = entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.copy();
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.green_rune_slot = ItemStack.EMPTY.copy();
						_vars.syncPlayerVariables(entity);
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, copySlot);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
