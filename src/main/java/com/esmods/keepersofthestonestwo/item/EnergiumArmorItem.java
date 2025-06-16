package com.esmods.keepersofthestonestwo.item;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import java.util.Map;

import com.google.common.collect.Iterables;

import com.esmods.keepersofthestonestwo.procedures.EnergiumItemsPowerLockedProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class EnergiumArmorItem extends ArmorItem {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(34, Map.of(ArmorType.BOOTS, 4, ArmorType.LEGGINGS, 13, ArmorType.CHESTPLATE, 10, ArmorType.HELMET, 4, ArmorType.BODY, 10), 20,
			BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), 0f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:energium_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("power:energium_armor")));

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/energium_layer_1.png");
			}
		}, PowerModItems.ENERGIUM_ARMOR_HELMET.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/energium_layer_1.png");
			}
		}, PowerModItems.ENERGIUM_ARMOR_CHESTPLATE.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/energium_layer_2.png");
			}
		}, PowerModItems.ENERGIUM_ARMOR_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/energium_layer_1.png");
			}
		}, PowerModItems.ENERGIUM_ARMOR_BOOTS.get());
	}

	private EnergiumArmorItem(ArmorType type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends EnergiumArmorItem {
		public Helmet(Item.Properties properties) {
			super(ArmorType.HELMET, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
			}
		}
	}

	public static class Chestplate extends EnergiumArmorItem {
		public Chestplate(Item.Properties properties) {
			super(ArmorType.CHESTPLATE, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
			}
		}
	}

	public static class Leggings extends EnergiumArmorItem {
		public Leggings(Item.Properties properties) {
			super(ArmorType.LEGGINGS, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
			}
		}
	}

	public static class Boots extends EnergiumArmorItem {
		public Boots(Item.Properties properties) {
			super(ArmorType.BOOTS, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
			}
		}
	}
}