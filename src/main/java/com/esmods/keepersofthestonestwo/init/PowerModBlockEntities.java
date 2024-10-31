
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import com.esmods.keepersofthestonestwo.block.entity.KeepersBoxBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.EnergiumVaultBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.ElementalPowerGeneratorBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.CursedVaultBlockEntity;
import com.esmods.keepersofthestonestwo.block.entity.BatteryChargerBlockEntity;
import com.esmods.keepersofthestonestwo.PowerMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PowerModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PowerMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BATTERY_CHARGER = register("battery_charger", PowerModBlocks.BATTERY_CHARGER, BatteryChargerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> KEEPERS_BOX = register("keepers_box", PowerModBlocks.KEEPERS_BOX, KeepersBoxBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ELEMENTAL_POWER_GENERATOR = register("elemental_power_generator", PowerModBlocks.ELEMENTAL_POWER_GENERATOR, ElementalPowerGeneratorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CURSED_VAULT = register("cursed_vault", PowerModBlocks.CURSED_VAULT, CursedVaultBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ENERGIUM_VAULT = register("energium_vault", PowerModBlocks.ENERGIUM_VAULT, EnergiumVaultBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BATTERY_CHARGER.get(), (blockEntity, side) -> ((BatteryChargerBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, KEEPERS_BOX.get(), (blockEntity, side) -> ((KeepersBoxBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ELEMENTAL_POWER_GENERATOR.get(), (blockEntity, side) -> ((ElementalPowerGeneratorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CURSED_VAULT.get(), (blockEntity, side) -> ((CursedVaultBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ENERGIUM_VAULT.get(), (blockEntity, side) -> ((EnergiumVaultBlockEntity) blockEntity).getItemHandler());
	}
}
