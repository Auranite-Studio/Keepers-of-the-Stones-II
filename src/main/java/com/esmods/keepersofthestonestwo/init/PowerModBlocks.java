
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import com.esmods.keepersofthestonestwo.block.RawEnergiumBlockBlock;
import com.esmods.keepersofthestonestwo.block.RawDepletedEnergiumBlockBlock;
import com.esmods.keepersofthestonestwo.block.RawCopyriumBlockBlock;
import com.esmods.keepersofthestonestwo.block.RawAmplifierBlockBlock;
import com.esmods.keepersofthestonestwo.block.PurpleMushroomBlock;
import com.esmods.keepersofthestonestwo.block.PolishedCursedStoneWallBlock;
import com.esmods.keepersofthestonestwo.block.PolishedCursedStoneStairsBlock;
import com.esmods.keepersofthestonestwo.block.PolishedCursedStoneSlabBlock;
import com.esmods.keepersofthestonestwo.block.PolishedCursedStoneBlock;
import com.esmods.keepersofthestonestwo.block.OrangePortalBlock;
import com.esmods.keepersofthestonestwo.block.MoonBlockBlock;
import com.esmods.keepersofthestonestwo.block.KeepersBoxBlock;
import com.esmods.keepersofthestonestwo.block.FreakingParsnipBlockBlock;
import com.esmods.keepersofthestonestwo.block.EnergiumVaultBlock;
import com.esmods.keepersofthestonestwo.block.EnergiumOreBlock;
import com.esmods.keepersofthestonestwo.block.EnergiumControllerBlock;
import com.esmods.keepersofthestonestwo.block.EnergiumBlockBlock;
import com.esmods.keepersofthestonestwo.block.ElementalPowerGeneratorBlock;
import com.esmods.keepersofthestonestwo.block.DepletedEnergiumOreBlock;
import com.esmods.keepersofthestonestwo.block.DepletedEnergiumBlockBlock;
import com.esmods.keepersofthestonestwo.block.DeepslateEnergiumOreBlock;
import com.esmods.keepersofthestonestwo.block.DeepslateDepletedEnergiumOreBlock;
import com.esmods.keepersofthestonestwo.block.DeepslateCopyriumOreBlock;
import com.esmods.keepersofthestonestwo.block.DeepslateAmplifierOreBlock;
import com.esmods.keepersofthestonestwo.block.CursedVaultBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneWallBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneStairsBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneSlabBlock;
import com.esmods.keepersofthestonestwo.block.CursedStonePillarBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneCrackedBricksWallBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneCrackedBricksStairsBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneCrackedBricksSlabBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneCrackedBricksBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneBricksWallBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneBricksStairsBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneBricksSlabBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneBricksBlock;
import com.esmods.keepersofthestonestwo.block.CursedStoneBlock;
import com.esmods.keepersofthestonestwo.block.CursedLanternBlock;
import com.esmods.keepersofthestonestwo.block.CursedLampBlock;
import com.esmods.keepersofthestonestwo.block.CursedLadderBlock;
import com.esmods.keepersofthestonestwo.block.CopyriumOreBlock;
import com.esmods.keepersofthestonestwo.block.CopyriumBlockBlock;
import com.esmods.keepersofthestonestwo.block.ChiseledCursedStoneBlock;
import com.esmods.keepersofthestonestwo.block.BluePortalBlock;
import com.esmods.keepersofthestonestwo.block.BatteryChargerBlock;
import com.esmods.keepersofthestonestwo.block.AmplifierOreBlock;
import com.esmods.keepersofthestonestwo.block.AmplifierBlockBlock;
import com.esmods.keepersofthestonestwo.block.AmberBlockBlock;
import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(PowerMod.MODID);
	public static final DeferredBlock<Block> DEPLETED_ENERGIUM_ORE = REGISTRY.registerBlock("depleted_energium_ore", DepletedEnergiumOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> DEPLETED_ENERGIUM_BLOCK = REGISTRY.registerBlock("depleted_energium_block", DepletedEnergiumBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> ENERGIUM_BLOCK = REGISTRY.registerBlock("energium_block", EnergiumBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> BATTERY_CHARGER = REGISTRY.registerBlock("battery_charger", BatteryChargerBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> KEEPERS_BOX = REGISTRY.registerBlock("keepers_box", KeepersBoxBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> MOON_BLOCK = REGISTRY.registerBlock("moon_block", MoonBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> ENERGIUM_CONTROLLER = REGISTRY.registerBlock("energium_controller", EnergiumControllerBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> AMPLIFIER_ORE = REGISTRY.registerBlock("amplifier_ore", AmplifierOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> AMPLIFIER_BLOCK = REGISTRY.registerBlock("amplifier_block", AmplifierBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> RAW_DEPLETED_ENERGIUM_BLOCK = REGISTRY.registerBlock("raw_depleted_energium_block", RawDepletedEnergiumBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> RAW_AMPLIFIER_BLOCK = REGISTRY.registerBlock("raw_amplifier_block", RawAmplifierBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> BLUE_PORTAL = REGISTRY.registerBlock("blue_portal", BluePortalBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> ORANGE_PORTAL = REGISTRY.registerBlock("orange_portal", OrangePortalBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> AMBER_BLOCK = REGISTRY.registerBlock("amber_block", AmberBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE = REGISTRY.registerBlock("cursed_stone", CursedStoneBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS = REGISTRY.registerBlock("cursed_stone_bricks", CursedStoneBricksBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_STAIRS = REGISTRY.registerBlock("cursed_stone_stairs", CursedStoneStairsBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_SLAB = REGISTRY.registerBlock("cursed_stone_slab", CursedStoneSlabBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS_STAIRS = REGISTRY.registerBlock("cursed_stone_bricks_stairs", CursedStoneBricksStairsBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS_SLAB = REGISTRY.registerBlock("cursed_stone_bricks_slab", CursedStoneBricksSlabBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_WALL = REGISTRY.registerBlock("cursed_stone_wall", CursedStoneWallBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_BRICKS_WALL = REGISTRY.registerBlock("cursed_stone_bricks_wall", CursedStoneBricksWallBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE = REGISTRY.registerBlock("polished_cursed_stone", PolishedCursedStoneBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE_STAIRS = REGISTRY.registerBlock("polished_cursed_stone_stairs", PolishedCursedStoneStairsBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE_SLAB = REGISTRY.registerBlock("polished_cursed_stone_slab", PolishedCursedStoneSlabBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> POLISHED_CURSED_STONE_WALL = REGISTRY.registerBlock("polished_cursed_stone_wall", PolishedCursedStoneWallBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_PILLAR = REGISTRY.registerBlock("cursed_stone_pillar", CursedStonePillarBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_LANTERN = REGISTRY.registerBlock("cursed_lantern", CursedLanternBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> COPYRIUM_ORE = REGISTRY.registerBlock("copyrium_ore", CopyriumOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> COPYRIUM_BLOCK = REGISTRY.registerBlock("copyrium_block", CopyriumBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> RAW_COPYRIUM_BLOCK = REGISTRY.registerBlock("raw_copyrium_block", RawCopyriumBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> ELEMENTAL_POWER_GENERATOR = REGISTRY.registerBlock("elemental_power_generator", ElementalPowerGeneratorBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_VAULT = REGISTRY.registerBlock("cursed_vault", CursedVaultBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_LADDER = REGISTRY.registerBlock("cursed_ladder", CursedLadderBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_LAMP = REGISTRY.registerBlock("cursed_lamp", CursedLampBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> ENERGIUM_VAULT = REGISTRY.registerBlock("energium_vault", EnergiumVaultBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> PURPLE_MUSHROOM = REGISTRY.registerBlock("purple_mushroom", PurpleMushroomBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> ENERGIUM_ORE = REGISTRY.registerBlock("energium_ore", EnergiumOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> RAW_ENERGIUM_BLOCK = REGISTRY.registerBlock("raw_energium_block", RawEnergiumBlockBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> DEEPSLATE_DEPLETED_ENERGIUM_ORE = REGISTRY.registerBlock("deepslate_depleted_energium_ore", DeepslateDepletedEnergiumOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> DEEPSLATE_ENERGIUM_ORE = REGISTRY.registerBlock("deepslate_energium_ore", DeepslateEnergiumOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> DEEPSLATE_AMPLIFIER_ORE = REGISTRY.registerBlock("deepslate_amplifier_ore", DeepslateAmplifierOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> DEEPSLATE_COPYRIUM_ORE = REGISTRY.registerBlock("deepslate_copyrium_ore", DeepslateCopyriumOreBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CHISELED_CURSED_STONE = REGISTRY.registerBlock("chiseled_cursed_stone", ChiseledCursedStoneBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS = REGISTRY.registerBlock("cursed_stone_cracked_bricks", CursedStoneCrackedBricksBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS_SLAB = REGISTRY.registerBlock("cursed_stone_cracked_bricks_slab", CursedStoneCrackedBricksSlabBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS_STAIRS = REGISTRY.registerBlock("cursed_stone_cracked_bricks_stairs", CursedStoneCrackedBricksStairsBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> CURSED_STONE_CRACKED_BRICKS_WALL = REGISTRY.registerBlock("cursed_stone_cracked_bricks_wall", CursedStoneCrackedBricksWallBlock::new, BlockBehaviour.Properties.of());
	public static final DeferredBlock<Block> FREAKING_PARSNIP_BLOCK = REGISTRY.registerBlock("freaking_parsnip_block", FreakingParsnipBlockBlock::new, BlockBehaviour.Properties.of());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
