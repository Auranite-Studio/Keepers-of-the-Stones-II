
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PowerMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS = REGISTRY.register("items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.power.items")).icon(() -> new ItemStack(PowerModItems.AMPLIFIER_RING.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PowerModItems.LUCK_COIN.get());
				tabData.accept(PowerModBlocks.AMPLIFIER_ORE.get().asItem());
				tabData.accept(PowerModBlocks.DEEPSLATE_AMPLIFIER_ORE.get().asItem());
				tabData.accept(PowerModBlocks.RAW_AMPLIFIER_BLOCK.get().asItem());
				tabData.accept(PowerModBlocks.AMPLIFIER_BLOCK.get().asItem());
				tabData.accept(PowerModItems.RAW_AMPLIFIER.get());
				tabData.accept(PowerModItems.AMPLIFIER_DROP.get());
				tabData.accept(PowerModItems.AMPLIFIER_RING.get());
				tabData.accept(PowerModBlocks.KEEPERS_BOX.get().asItem());
				tabData.accept(PowerModBlocks.DEPLETED_ENERGIUM_ORE.get().asItem());
				tabData.accept(PowerModBlocks.DEEPSLATE_DEPLETED_ENERGIUM_ORE.get().asItem());
				tabData.accept(PowerModBlocks.ENERGIUM_ORE.get().asItem());
				tabData.accept(PowerModBlocks.DEEPSLATE_ENERGIUM_ORE.get().asItem());
				tabData.accept(PowerModBlocks.RAW_DEPLETED_ENERGIUM_BLOCK.get().asItem());
				tabData.accept(PowerModBlocks.RAW_ENERGIUM_BLOCK.get().asItem());
				tabData.accept(PowerModBlocks.DEPLETED_ENERGIUM_BLOCK.get().asItem());
				tabData.accept(PowerModBlocks.ENERGIUM_BLOCK.get().asItem());
				tabData.accept(PowerModBlocks.ENERGIUM_CONTROLLER.get().asItem());
				tabData.accept(PowerModItems.RAW_ENERGIUM.get());
				tabData.accept(PowerModItems.RAW_DEPLETED_ENERGIUM.get());
				tabData.accept(PowerModItems.DEPLETED_ENERGIUM_INGOT.get());
				tabData.accept(PowerModItems.ENERGIUM_INGOT.get());
				tabData.accept(PowerModItems.ENERGIUM_DUST.get());
				tabData.accept(PowerModBlocks.BATTERY_CHARGER.get().asItem());
				tabData.accept(PowerModItems.ENERGIUM_UPGRADE_SMITHING_TEMPLATE.get());
				tabData.accept(PowerModItems.ENERGIUM_PICKAXE.get());
				tabData.accept(PowerModItems.ENERGIUM_AXE.get());
				tabData.accept(PowerModItems.ENERGIUM_SWORD.get());
				tabData.accept(PowerModItems.ENERGIUM_SHOVEL.get());
				tabData.accept(PowerModItems.ENERGIUM_HOE.get());
				tabData.accept(PowerModItems.ENERGIUM_ARMOR_HELMET.get());
				tabData.accept(PowerModItems.ENERGIUM_ARMOR_CHESTPLATE.get());
				tabData.accept(PowerModItems.ENERGIUM_ARMOR_LEGGINGS.get());
				tabData.accept(PowerModItems.ENERGIUM_ARMOR_BOOTS.get());
				tabData.accept(PowerModItems.ENERGIUM_CORE.get());
				tabData.accept(PowerModBlocks.ENERGIUM_VAULT.get().asItem());
				tabData.accept(PowerModItems.ENERGIUM_KEY.get());
				tabData.accept(PowerModItems.MUSIC_DISC_CALL_OF_THE_PAST.get());
				tabData.accept(PowerModBlocks.COPYRIUM_ORE.get().asItem());
				tabData.accept(PowerModBlocks.DEEPSLATE_COPYRIUM_ORE.get().asItem());
				tabData.accept(PowerModBlocks.RAW_COPYRIUM_BLOCK.get().asItem());
				tabData.accept(PowerModBlocks.COPYRIUM_BLOCK.get().asItem());
				tabData.accept(PowerModBlocks.ELEMENTAL_POWER_GENERATOR.get().asItem());
				tabData.accept(PowerModItems.RAW_COPYRIUM.get());
				tabData.accept(PowerModItems.COPYRIUM_INGOT.get());
				tabData.accept(PowerModBlocks.CURSED_STONE.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_BRICKS.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_CRACKED_BRICKS.get().asItem());
				tabData.accept(PowerModBlocks.POLISHED_CURSED_STONE.get().asItem());
				tabData.accept(PowerModBlocks.CHISELED_CURSED_STONE.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_PILLAR.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_STAIRS.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_BRICKS_STAIRS.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_CRACKED_BRICKS_STAIRS.get().asItem());
				tabData.accept(PowerModBlocks.POLISHED_CURSED_STONE_STAIRS.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_SLAB.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_BRICKS_SLAB.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_CRACKED_BRICKS_SLAB.get().asItem());
				tabData.accept(PowerModBlocks.POLISHED_CURSED_STONE_SLAB.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_WALL.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_BRICKS_WALL.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_STONE_CRACKED_BRICKS_WALL.get().asItem());
				tabData.accept(PowerModBlocks.POLISHED_CURSED_STONE_WALL.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_LADDER.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_LAMP.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_LANTERN.get().asItem());
				tabData.accept(PowerModBlocks.CURSED_VAULT.get().asItem());
				tabData.accept(PowerModItems.CURSED_KEY.get());
				tabData.accept(PowerModItems.MUSIC_DISC_ANCIENT_MOOD.get());
				tabData.accept(PowerModItems.FREAKING_PARSNIP.get());
				tabData.accept(PowerModItems.FREAKING_PARSNIP_SOUP.get());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STONES = REGISTRY.register("stones",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.power.stones")).icon(() -> new ItemStack(PowerModItems.FIRE_STONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PowerModItems.FIRE_STONE.get());
				tabData.accept(PowerModItems.AIR_STONE.get());
				tabData.accept(PowerModItems.EARTH_STONE.get());
				tabData.accept(PowerModItems.WATER_STONE.get());
				tabData.accept(PowerModItems.ETHER_STONE.get());
				tabData.accept(PowerModItems.ICE_STONE.get());
				tabData.accept(PowerModItems.LIGHTNING_STONE.get());
				tabData.accept(PowerModItems.SOUND_STONE.get());
				tabData.accept(PowerModItems.CRYSTAL_STONE.get());
				tabData.accept(PowerModItems.LAVA_STONE.get());
				tabData.accept(PowerModItems.RAIN_STONE.get());
				tabData.accept(PowerModItems.TORNADO_STONE.get());
				tabData.accept(PowerModItems.OCEAN_STONE.get());
				tabData.accept(PowerModItems.PLANTS_STONE.get());
				tabData.accept(PowerModItems.ANIMALS_STONE.get());
				tabData.accept(PowerModItems.METAL_STONE.get());
				tabData.accept(PowerModItems.LIGHT_STONE.get());
				tabData.accept(PowerModItems.SHADOW_STONE.get());
				tabData.accept(PowerModItems.VACUUM_STONE.get());
				tabData.accept(PowerModItems.ENERGY_STONE.get());
				tabData.accept(PowerModItems.SUN_STONE.get());
				tabData.accept(PowerModItems.MOON_STONE.get());
				tabData.accept(PowerModItems.SPACE_STONE.get());
				tabData.accept(PowerModItems.TIME_STONE.get());
				tabData.accept(PowerModItems.CREATION_STONE.get());
				tabData.accept(PowerModItems.DESTRUCTION_STONE.get());
				tabData.accept(PowerModItems.BLOOD_STONE.get());
				tabData.accept(PowerModItems.TECHNOLOGY_STONE.get());
				tabData.accept(PowerModItems.TELEPORTATION_STONE.get());
				tabData.accept(PowerModItems.EXPLOSION_STONE.get());
				tabData.accept(PowerModItems.AMBER_STONE.get());
				tabData.accept(PowerModItems.MIST_STONE.get());
				tabData.accept(PowerModItems.SAND_STONE.get());
				tabData.accept(PowerModItems.SPEED_STONE.get());
				tabData.accept(PowerModItems.POISON_STONE.get());
				tabData.accept(PowerModItems.MAGNET_STONE.get());
				tabData.accept(PowerModItems.MUSHROOMS_STONE.get());
				tabData.accept(PowerModItems.MERCURY_STONE.get());
				tabData.accept(PowerModItems.MUSIC_STONE.get());
				tabData.accept(PowerModItems.PLAGUE_STONE.get());
				tabData.accept(PowerModItems.BLUE_FLAME_STONE.get());
				tabData.accept(PowerModItems.GRAVITY_STONE.get());
				tabData.accept(PowerModItems.SMOKE_STONE.get());
				tabData.accept(PowerModItems.SPIRIT_STONE.get());
				tabData.accept(PowerModItems.FORM_STONE.get());
				tabData.accept(PowerModItems.MIND_STONE.get());
				tabData.accept(PowerModItems.GOLDEN_DUST_STONE.get());
				tabData.accept(PowerModItems.DARKNESS_STONE.get());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOBS = REGISTRY.register("mobs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.power.mobs")).icon(() -> new ItemStack(PowerModItems.ENERGIUM_GOLEM_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PowerModItems.ENERGIUM_GOLEM_SPAWN_EGG.get());
				tabData.accept(PowerModItems.CURSED_KEEPER_SPAWN_EGG.get());
				tabData.accept(PowerModItems.CURSED_KNIGHT_SPAWN_EGG.get());
				tabData.accept(PowerModItems.CURSED_SQUIRE_SPAWN_EGG.get());
			})

					.build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BATTERIES = REGISTRY.register("batteries",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.power.batteries")).icon(() -> new ItemStack(PowerModItems.EMPTY_BATTERY.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PowerModItems.EMPTY_BATTERY.get());
				tabData.accept(PowerModItems.FIRE_BATTERY.get());
				tabData.accept(PowerModItems.AIR_BATTERY.get());
				tabData.accept(PowerModItems.EARTH_BATTERY.get());
				tabData.accept(PowerModItems.WATER_BATTERY.get());
				tabData.accept(PowerModItems.ETHER_BATTERY.get());
				tabData.accept(PowerModItems.ICE_BATTERY.get());
				tabData.accept(PowerModItems.LIGHTNING_BATTERY.get());
				tabData.accept(PowerModItems.SOUND_BATTERY.get());
				tabData.accept(PowerModItems.CRYSTAL_BATTERY.get());
				tabData.accept(PowerModItems.LAVA_BATTERY.get());
				tabData.accept(PowerModItems.RAIN_BATTERY.get());
				tabData.accept(PowerModItems.TORNADO_BATTERY.get());
				tabData.accept(PowerModItems.OCEAN_BATTERY.get());
				tabData.accept(PowerModItems.PLANTS_BATTERY.get());
				tabData.accept(PowerModItems.ANIMALS_BATTERY.get());
				tabData.accept(PowerModItems.METAL_BATTERY.get());
				tabData.accept(PowerModItems.LIGHT_BATTERY.get());
				tabData.accept(PowerModItems.SHADOW_BATTERY.get());
				tabData.accept(PowerModItems.VACUUM_BATTERY.get());
				tabData.accept(PowerModItems.ENERGY_BATTERY.get());
				tabData.accept(PowerModItems.SUN_BATTERY.get());
				tabData.accept(PowerModItems.MOON_BATTERY.get());
				tabData.accept(PowerModItems.SPACE_BATTERY.get());
				tabData.accept(PowerModItems.TIME_BATTERY.get());
				tabData.accept(PowerModItems.CREATION_BATTERY.get());
				tabData.accept(PowerModItems.DESTRUCTION_BATTERY.get());
				tabData.accept(PowerModItems.BLOOD_BATTERY.get());
				tabData.accept(PowerModItems.TECHNOLOGY_BATTERY.get());
				tabData.accept(PowerModItems.TELEPORTATION_BATTERY.get());
				tabData.accept(PowerModItems.EXPLOSION_BATTERY.get());
				tabData.accept(PowerModItems.AMBER_BATTERY.get());
				tabData.accept(PowerModItems.MIST_BATTERY.get());
				tabData.accept(PowerModItems.SAND_BATTERY.get());
				tabData.accept(PowerModItems.SPEED_BATTERY.get());
				tabData.accept(PowerModItems.POISON_BATTERY.get());
				tabData.accept(PowerModItems.MAGNET_BATTERY.get());
				tabData.accept(PowerModItems.MUSHROOMS_BATTERY.get());
				tabData.accept(PowerModItems.MERCURY_BATTERY.get());
				tabData.accept(PowerModItems.MUSIC_BATTERY.get());
				tabData.accept(PowerModItems.PLAGUE_BATTERY.get());
				tabData.accept(PowerModItems.BLUE_FLAME_BATTERY.get());
				tabData.accept(PowerModItems.GRAVITY_BATTERY.get());
				tabData.accept(PowerModItems.SMOKE_BATTERY.get());
				tabData.accept(PowerModItems.SPIRIT_BATTERY.get());
				tabData.accept(PowerModItems.FORM_BATTERY.get());
				tabData.accept(PowerModItems.MIND_BATTERY.get());
				tabData.accept(PowerModItems.GOLDEN_DUST_BATTERY.get());
				tabData.accept(PowerModItems.DARKNESS_BATTERY.get());
			})

					.build());
}
