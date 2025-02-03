package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

import java.util.Collections;

import com.esmods.keepersofthestonestwo.init.PowerModItems;
import com.esmods.keepersofthestonestwo.init.PowerModBlocks;

@EventBusSubscriber
public class UnlockRecipesProcedure {
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
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.DEPLETED_ENERGIUM_INGOT.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:empty_battery_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:depleted_energium_ore_block_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:battery_charger_recipe"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.DEPLETED_ENERGIUM_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:depleted_energium_block_ore_recipe"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.ENERGIUM_INGOT.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_ore_block_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_sword_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_axe_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_pickaxe_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_shovel_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_hoe_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_armor_helmet_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_armor_chestplate_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_armor_leggings_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_armor_boots_recipe"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.ENERGIUM_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_block_ore_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_controller_recipe"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.ENERGIUM_UPGRADE_SMITHING_TEMPLATE.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:duplicate_energium_upgrade_smithing_template"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.ENERGIUM_CORE.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:energium_controller_recipe"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.RAW_DEPLETED_ENERGIUM_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:raw_depleted_energium_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.RAW_DEPLETED_ENERGIUM_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:raw_depleted_energium_block_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.AMPLIFIER_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:amplifier_drop_from_block"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:cursed_lamp_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.AMPLIFIER_DROP.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:amplifier_block_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:amplifier_ring_craft"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:elemental_power_generator_craft"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:cursed_lantern_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.RAW_AMPLIFIER_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:raw_amplifier_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.RAW_AMPLIFIER.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:raw_amplifier_block_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.RAW_COPYRIUM.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:raw_copyrium_block_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.RAW_COPYRIUM_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:raw_copyrium_from_block_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.COPYRIUM_INGOT.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:copyrium_ore_block_recipe"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:elemental_power_generator_craft"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:characteristics_card_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.COPYRIUM_BLOCK.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:copyrium_block_ore_recipe"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.CURSED_STONE.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:cursed_ladder_craft"))));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:cursed_lantern_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModBlocks.CURSED_STONE_BRICKS.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:cursed_lamp_craft"))));
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PowerModItems.FREAKING_PARSNIP.get())) : false) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse("power:freaking_parsnip_soup_craft"))));
		}
	}
}
