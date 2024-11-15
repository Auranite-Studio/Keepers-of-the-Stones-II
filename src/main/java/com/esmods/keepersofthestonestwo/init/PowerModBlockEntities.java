
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.esmods.keepersofthestonestwo.block.entity.KeepersBoxBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.EnergiumVaultBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.ElementalPowerGeneratorBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.CursedVaultBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.BatteryChargerBlockEntity;
import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PowerMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> BATTERY_CHARGER = register("battery_charger", PowerModBlocks.BATTERY_CHARGER, BatteryChargerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> KEEPERS_BOX = register("keepers_box", PowerModBlocks.KEEPERS_BOX, KeepersBoxBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ELEMENTAL_POWER_GENERATOR = register("elemental_power_generator", PowerModBlocks.ELEMENTAL_POWER_GENERATOR, ElementalPowerGeneratorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CURSED_VAULT = register("cursed_vault", PowerModBlocks.CURSED_VAULT, CursedVaultBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENERGIUM_VAULT = register("energium_vault", PowerModBlocks.ENERGIUM_VAULT, EnergiumVaultBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
