
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

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
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PowerMod.MODID);
	public static final RegistryObject<Block> DEPLETED_ENERGIUM_ORE = REGISTRY.register("depleted_energium_ore", () -> new DepletedEnergiumOreBlock());
	public static final RegistryObject<Block> DEPLETED_ENERGIUM_BLOCK = REGISTRY.register("depleted_energium_block", () -> new DepletedEnergiumBlockBlock());
	public static final RegistryObject<Block> ENERGIUM_BLOCK = REGISTRY.register("energium_block", () -> new EnergiumBlockBlock());
	public static final RegistryObject<Block> BATTERY_CHARGER = REGISTRY.register("battery_charger", () -> new BatteryChargerBlock());
	public static final RegistryObject<Block> KEEPERS_BOX = REGISTRY.register("keepers_box", () -> new KeepersBoxBlock());
	public static final RegistryObject<Block> MOON_BLOCK = REGISTRY.register("moon_block", () -> new MoonBlockBlock());
	public static final RegistryObject<Block> ENERGIUM_CONTROLLER = REGISTRY.register("energium_controller", () -> new EnergiumControllerBlock());
	public static final RegistryObject<Block> AMPLIFIER_ORE = REGISTRY.register("amplifier_ore", () -> new AmplifierOreBlock());
	public static final RegistryObject<Block> AMPLIFIER_BLOCK = REGISTRY.register("amplifier_block", () -> new AmplifierBlockBlock());
	public static final RegistryObject<Block> RAW_DEPLETED_ENERGIUM_BLOCK = REGISTRY.register("raw_depleted_energium_block", () -> new RawDepletedEnergiumBlockBlock());
	public static final RegistryObject<Block> RAW_AMPLIFIER_BLOCK = REGISTRY.register("raw_amplifier_block", () -> new RawAmplifierBlockBlock());
	public static final RegistryObject<Block> BLUE_PORTAL = REGISTRY.register("blue_portal", () -> new BluePortalBlock());
	public static final RegistryObject<Block> ORANGE_PORTAL = REGISTRY.register("orange_portal", () -> new OrangePortalBlock());
	public static final RegistryObject<Block> AMBER_BLOCK = REGISTRY.register("amber_block", () -> new AmberBlockBlock());
	public static final RegistryObject<Block> CURSED_STONE = REGISTRY.register("cursed_stone", () -> new CursedStoneBlock());
	public static final RegistryObject<Block> CURSED_STONE_BRICKS = REGISTRY.register("cursed_stone_bricks", () -> new CursedStoneBricksBlock());
	public static final RegistryObject<Block> CURSED_STONE_STAIRS = REGISTRY.register("cursed_stone_stairs", () -> new CursedStoneStairsBlock());
	public static final RegistryObject<Block> CURSED_STONE_SLAB = REGISTRY.register("cursed_stone_slab", () -> new CursedStoneSlabBlock());
	public static final RegistryObject<Block> CURSED_STONE_BRICKS_STAIRS = REGISTRY.register("cursed_stone_bricks_stairs", () -> new CursedStoneBricksStairsBlock());
	public static final RegistryObject<Block> CURSED_STONE_BRICKS_SLAB = REGISTRY.register("cursed_stone_bricks_slab", () -> new CursedStoneBricksSlabBlock());
	public static final RegistryObject<Block> CURSED_STONE_WALL = REGISTRY.register("cursed_stone_wall", () -> new CursedStoneWallBlock());
	public static final RegistryObject<Block> CURSED_STONE_BRICKS_WALL = REGISTRY.register("cursed_stone_bricks_wall", () -> new CursedStoneBricksWallBlock());
	public static final RegistryObject<Block> POLISHED_CURSED_STONE = REGISTRY.register("polished_cursed_stone", () -> new PolishedCursedStoneBlock());
	public static final RegistryObject<Block> POLISHED_CURSED_STONE_STAIRS = REGISTRY.register("polished_cursed_stone_stairs", () -> new PolishedCursedStoneStairsBlock());
	public static final RegistryObject<Block> POLISHED_CURSED_STONE_SLAB = REGISTRY.register("polished_cursed_stone_slab", () -> new PolishedCursedStoneSlabBlock());
	public static final RegistryObject<Block> POLISHED_CURSED_STONE_WALL = REGISTRY.register("polished_cursed_stone_wall", () -> new PolishedCursedStoneWallBlock());
	public static final RegistryObject<Block> CURSED_STONE_PILLAR = REGISTRY.register("cursed_stone_pillar", () -> new CursedStonePillarBlock());
	public static final RegistryObject<Block> CURSED_LANTERN = REGISTRY.register("cursed_lantern", () -> new CursedLanternBlock());
	public static final RegistryObject<Block> COPYRIUM_ORE = REGISTRY.register("copyrium_ore", () -> new CopyriumOreBlock());
	public static final RegistryObject<Block> COPYRIUM_BLOCK = REGISTRY.register("copyrium_block", () -> new CopyriumBlockBlock());
	public static final RegistryObject<Block> RAW_COPYRIUM_BLOCK = REGISTRY.register("raw_copyrium_block", () -> new RawCopyriumBlockBlock());
	public static final RegistryObject<Block> ELEMENTAL_POWER_GENERATOR = REGISTRY.register("elemental_power_generator", () -> new ElementalPowerGeneratorBlock());
	public static final RegistryObject<Block> CURSED_VAULT = REGISTRY.register("cursed_vault", () -> new CursedVaultBlock());
	public static final RegistryObject<Block> CURSED_LADDER = REGISTRY.register("cursed_ladder", () -> new CursedLadderBlock());
	public static final RegistryObject<Block> CURSED_LAMP = REGISTRY.register("cursed_lamp", () -> new CursedLampBlock());
	public static final RegistryObject<Block> ENERGIUM_VAULT = REGISTRY.register("energium_vault", () -> new EnergiumVaultBlock());
	public static final RegistryObject<Block> PURPLE_MUSHROOM = REGISTRY.register("purple_mushroom", () -> new PurpleMushroomBlock());
	public static final RegistryObject<Block> ENERGIUM_ORE = REGISTRY.register("energium_ore", () -> new EnergiumOreBlock());
	public static final RegistryObject<Block> RAW_ENERGIUM_BLOCK = REGISTRY.register("raw_energium_block", () -> new RawEnergiumBlockBlock());
	public static final RegistryObject<Block> DEEPSLATE_DEPLETED_ENERGIUM_ORE = REGISTRY.register("deepslate_depleted_energium_ore", () -> new DeepslateDepletedEnergiumOreBlock());
	public static final RegistryObject<Block> DEEPSLATE_ENERGIUM_ORE = REGISTRY.register("deepslate_energium_ore", () -> new DeepslateEnergiumOreBlock());
	public static final RegistryObject<Block> DEEPSLATE_AMPLIFIER_ORE = REGISTRY.register("deepslate_amplifier_ore", () -> new DeepslateAmplifierOreBlock());
	public static final RegistryObject<Block> DEEPSLATE_COPYRIUM_ORE = REGISTRY.register("deepslate_copyrium_ore", () -> new DeepslateCopyriumOreBlock());
	public static final RegistryObject<Block> CHISELED_CURSED_STONE = REGISTRY.register("chiseled_cursed_stone", () -> new ChiseledCursedStoneBlock());
	public static final RegistryObject<Block> CURSED_STONE_CRACKED_BRICKS = REGISTRY.register("cursed_stone_cracked_bricks", () -> new CursedStoneCrackedBricksBlock());
	public static final RegistryObject<Block> CURSED_STONE_CRACKED_BRICKS_SLAB = REGISTRY.register("cursed_stone_cracked_bricks_slab", () -> new CursedStoneCrackedBricksSlabBlock());
	public static final RegistryObject<Block> CURSED_STONE_CRACKED_BRICKS_STAIRS = REGISTRY.register("cursed_stone_cracked_bricks_stairs", () -> new CursedStoneCrackedBricksStairsBlock());
	public static final RegistryObject<Block> CURSED_STONE_CRACKED_BRICKS_WALL = REGISTRY.register("cursed_stone_cracked_bricks_wall", () -> new CursedStoneCrackedBricksWallBlock());
	public static final RegistryObject<Block> FREAKING_PARSNIP_BLOCK = REGISTRY.register("freaking_parsnip_block", () -> new FreakingParsnipBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
