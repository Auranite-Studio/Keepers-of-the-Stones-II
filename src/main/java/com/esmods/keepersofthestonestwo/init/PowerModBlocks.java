/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import com.esmods.keepersofthestonestwo.block.*;
import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(PowerMod.MODID);
	public static final DeferredBlock<Block> DEPLETED_ENERGIUM_ORE;
	public static final DeferredBlock<Block> DEPLETED_ENERGIUM_BLOCK;
	public static final DeferredBlock<Block> ENERGIUM_BLOCK;
	public static final DeferredBlock<Block> BATTERY_CHARGER;
	public static final DeferredBlock<Block> KEEPERS_BOX;
	public static final DeferredBlock<Block> MOON_BLOCK;
	public static final DeferredBlock<Block> ENERGIUM_CONTROLLER;
	public static final DeferredBlock<Block> AMPLIFIER_ORE;
	public static final DeferredBlock<Block> AMPLIFIER_BLOCK;
	public static final DeferredBlock<Block> RAW_DEPLETED_ENERGIUM_BLOCK;
	public static final DeferredBlock<Block> RAW_AMPLIFIER_BLOCK;
	public static final DeferredBlock<Block> BLUE_PORTAL;
	public static final DeferredBlock<Block> ORANGE_PORTAL;
	public static final DeferredBlock<Block> AMBER_BLOCK;
	public static final DeferredBlock<Block> CURSED_STONE;
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS;
	public static final DeferredBlock<Block> CURSED_STONE_STAIRS;
	public static final DeferredBlock<Block> CURSED_STONE_SLAB;
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS_STAIRS;
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS_SLAB;
	public static final DeferredBlock<Block> CURSED_STONE_WALL;
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS_WALL;
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE;
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE_STAIRS;
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE_SLAB;
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE_WALL;
	public static final DeferredBlock<Block> CURSED_STONE_PILLAR;
	public static final DeferredBlock<Block> CURSED_LANTERN;
	public static final DeferredBlock<Block> COPYRIUM_ORE;
	public static final DeferredBlock<Block> COPYRIUM_BLOCK;
	public static final DeferredBlock<Block> RAW_COPYRIUM_BLOCK;
	public static final DeferredBlock<Block> ELEMENTAL_POWER_GENERATOR;
	public static final DeferredBlock<Block> CURSED_VAULT;
	public static final DeferredBlock<Block> CURSED_LADDER;
	public static final DeferredBlock<Block> CURSED_LAMP;
	public static final DeferredBlock<Block> ENERGIUM_VAULT;
	public static final DeferredBlock<Block> PURPLE_MUSHROOM;
	public static final DeferredBlock<Block> ENERGIUM_ORE;
	public static final DeferredBlock<Block> RAW_ENERGIUM_BLOCK;
	public static final DeferredBlock<Block> DEEPSLATE_DEPLETED_ENERGIUM_ORE;
	public static final DeferredBlock<Block> DEEPSLATE_ENERGIUM_ORE;
	public static final DeferredBlock<Block> DEEPSLATE_AMPLIFIER_ORE;
	public static final DeferredBlock<Block> DEEPSLATE_COPYRIUM_ORE;
	public static final DeferredBlock<Block> CHISELED_CURSED_STONE;
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS;
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS_SLAB;
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS_STAIRS;
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS_WALL;
	public static final DeferredBlock<Block> FREAKING_PARSNIP_BLOCK;
	public static final DeferredBlock<Block> RUNE_CUTTER;
	public static final DeferredBlock<Block> CURSED_WORLD_PORTAL;
	public static final DeferredBlock<Block> TEARS_FLOWER;
	static {
		DEPLETED_ENERGIUM_ORE = REGISTRY.register("depleted_energium_ore", DepletedEnergiumOreBlock::new);
		DEPLETED_ENERGIUM_BLOCK = REGISTRY.register("depleted_energium_block", DepletedEnergiumBlockBlock::new);
		ENERGIUM_BLOCK = REGISTRY.register("energium_block", EnergiumBlockBlock::new);
		BATTERY_CHARGER = REGISTRY.register("battery_charger", BatteryChargerBlock::new);
		KEEPERS_BOX = REGISTRY.register("keepers_box", KeepersBoxBlock::new);
		MOON_BLOCK = REGISTRY.register("moon_block", MoonBlockBlock::new);
		ENERGIUM_CONTROLLER = REGISTRY.register("energium_controller", EnergiumControllerBlock::new);
		AMPLIFIER_ORE = REGISTRY.register("amplifier_ore", AmplifierOreBlock::new);
		AMPLIFIER_BLOCK = REGISTRY.register("amplifier_block", AmplifierBlockBlock::new);
		RAW_DEPLETED_ENERGIUM_BLOCK = REGISTRY.register("raw_depleted_energium_block", RawDepletedEnergiumBlockBlock::new);
		RAW_AMPLIFIER_BLOCK = REGISTRY.register("raw_amplifier_block", RawAmplifierBlockBlock::new);
		BLUE_PORTAL = REGISTRY.register("blue_portal", BluePortalBlock::new);
		ORANGE_PORTAL = REGISTRY.register("orange_portal", OrangePortalBlock::new);
		AMBER_BLOCK = REGISTRY.register("amber_block", AmberBlockBlock::new);
		CURSED_STONE = REGISTRY.register("cursed_stone", CursedStoneBlock::new);
		CURSED_STONE_BRICKS = REGISTRY.register("cursed_stone_bricks", CursedStoneBricksBlock::new);
		CURSED_STONE_STAIRS = REGISTRY.register("cursed_stone_stairs", CursedStoneStairsBlock::new);
		CURSED_STONE_SLAB = REGISTRY.register("cursed_stone_slab", CursedStoneSlabBlock::new);
		CURSED_STONE_BRICKS_STAIRS = REGISTRY.register("cursed_stone_bricks_stairs", CursedStoneBricksStairsBlock::new);
		CURSED_STONE_BRICKS_SLAB = REGISTRY.register("cursed_stone_bricks_slab", CursedStoneBricksSlabBlock::new);
		CURSED_STONE_WALL = REGISTRY.register("cursed_stone_wall", CursedStoneWallBlock::new);
		CURSED_STONE_BRICKS_WALL = REGISTRY.register("cursed_stone_bricks_wall", CursedStoneBricksWallBlock::new);
		POLISHED_CURSED_STONE = REGISTRY.register("polished_cursed_stone", PolishedCursedStoneBlock::new);
		POLISHED_CURSED_STONE_STAIRS = REGISTRY.register("polished_cursed_stone_stairs", PolishedCursedStoneStairsBlock::new);
		POLISHED_CURSED_STONE_SLAB = REGISTRY.register("polished_cursed_stone_slab", PolishedCursedStoneSlabBlock::new);
		POLISHED_CURSED_STONE_WALL = REGISTRY.register("polished_cursed_stone_wall", PolishedCursedStoneWallBlock::new);
		CURSED_STONE_PILLAR = REGISTRY.register("cursed_stone_pillar", CursedStonePillarBlock::new);
		CURSED_LANTERN = REGISTRY.register("cursed_lantern", CursedLanternBlock::new);
		COPYRIUM_ORE = REGISTRY.register("copyrium_ore", CopyriumOreBlock::new);
		COPYRIUM_BLOCK = REGISTRY.register("copyrium_block", CopyriumBlockBlock::new);
		RAW_COPYRIUM_BLOCK = REGISTRY.register("raw_copyrium_block", RawCopyriumBlockBlock::new);
		ELEMENTAL_POWER_GENERATOR = REGISTRY.register("elemental_power_generator", ElementalPowerGeneratorBlock::new);
		CURSED_VAULT = REGISTRY.register("cursed_vault", CursedVaultBlock::new);
		CURSED_LADDER = REGISTRY.register("cursed_ladder", CursedLadderBlock::new);
		CURSED_LAMP = REGISTRY.register("cursed_lamp", CursedLampBlock::new);
		ENERGIUM_VAULT = REGISTRY.register("energium_vault", EnergiumVaultBlock::new);
		PURPLE_MUSHROOM = REGISTRY.register("purple_mushroom", PurpleMushroomBlock::new);
		ENERGIUM_ORE = REGISTRY.register("energium_ore", EnergiumOreBlock::new);
		RAW_ENERGIUM_BLOCK = REGISTRY.register("raw_energium_block", RawEnergiumBlockBlock::new);
		DEEPSLATE_DEPLETED_ENERGIUM_ORE = REGISTRY.register("deepslate_depleted_energium_ore", DeepslateDepletedEnergiumOreBlock::new);
		DEEPSLATE_ENERGIUM_ORE = REGISTRY.register("deepslate_energium_ore", DeepslateEnergiumOreBlock::new);
		DEEPSLATE_AMPLIFIER_ORE = REGISTRY.register("deepslate_amplifier_ore", DeepslateAmplifierOreBlock::new);
		DEEPSLATE_COPYRIUM_ORE = REGISTRY.register("deepslate_copyrium_ore", DeepslateCopyriumOreBlock::new);
		CHISELED_CURSED_STONE = REGISTRY.register("chiseled_cursed_stone", ChiseledCursedStoneBlock::new);
		CURSED_STONE_CRACKED_BRICKS = REGISTRY.register("cursed_stone_cracked_bricks", CursedStoneCrackedBricksBlock::new);
		CURSED_STONE_CRACKED_BRICKS_SLAB = REGISTRY.register("cursed_stone_cracked_bricks_slab", CursedStoneCrackedBricksSlabBlock::new);
		CURSED_STONE_CRACKED_BRICKS_STAIRS = REGISTRY.register("cursed_stone_cracked_bricks_stairs", CursedStoneCrackedBricksStairsBlock::new);
		CURSED_STONE_CRACKED_BRICKS_WALL = REGISTRY.register("cursed_stone_cracked_bricks_wall", CursedStoneCrackedBricksWallBlock::new);
		FREAKING_PARSNIP_BLOCK = REGISTRY.register("freaking_parsnip_block", FreakingParsnipBlockBlock::new);
		RUNE_CUTTER = REGISTRY.register("rune_cutter", RuneCutterBlock::new);
		CURSED_WORLD_PORTAL = REGISTRY.register("cursed_world_portal", CursedWorldPortalBlock::new);
		TEARS_FLOWER = REGISTRY.register("tears_flower", TearsFlowerBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}