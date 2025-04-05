
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import java.util.Map;

import com.google.common.collect.Iterables;

import com.esmods.keepersofthestonestwo.procedures.RemoveForbiddenItemProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class MistArmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(37, Map.of(ArmorType.BOOTS, 3, ArmorType.LEGGINGS, 6, ArmorType.CHESTPLATE, 8, ArmorType.HELMET, 3, ArmorType.BODY, 8), 1,
			BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), 0f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:mist_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("power:mist_armor")));

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/mist_armor_layer_1.png");
			}
		}, PowerModItems.MIST_ARMOR_HELMET.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/mist_armor_layer_1.png");
			}
		}, PowerModItems.MIST_ARMOR_CHESTPLATE.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/mist_armor_layer_2.png");
			}
		}, PowerModItems.MIST_ARMOR_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power:textures/models/armor/mist_armor_layer_1.png");
			}
		}, PowerModItems.MIST_ARMOR_BOOTS.get());
	}

	private MistArmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends MistArmorItem {
		public Helmet(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, EquipmentSlot slot) {
			super.inventoryTick(itemstack, world, entity, slot);
			if (entity instanceof Player player && !Iterables.contains(player.getInventory().getNonEquipmentItems(), itemstack)) {
				RemoveForbiddenItemProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Chestplate extends MistArmorItem {
		public Chestplate(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, EquipmentSlot slot) {
			super.inventoryTick(itemstack, world, entity, slot);
			if (entity instanceof Player player && !Iterables.contains(player.getInventory().getNonEquipmentItems(), itemstack)) {
				RemoveForbiddenItemProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Leggings extends MistArmorItem {
		public Leggings(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, EquipmentSlot slot) {
			super.inventoryTick(itemstack, world, entity, slot);
			if (entity instanceof Player player && !Iterables.contains(player.getInventory().getNonEquipmentItems(), itemstack)) {
				RemoveForbiddenItemProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Boots extends MistArmorItem {
		public Boots(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, EquipmentSlot slot) {
			super.inventoryTick(itemstack, world, entity, slot);
			if (entity instanceof Player player && !Iterables.contains(player.getInventory().getNonEquipmentItems(), itemstack)) {
				RemoveForbiddenItemProcedure.execute(entity, itemstack);
			}
		}
	}
}
