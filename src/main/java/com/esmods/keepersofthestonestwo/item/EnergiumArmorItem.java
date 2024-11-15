
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import java.util.List;
import java.util.EnumMap;

import com.google.common.collect.Iterables;

import com.esmods.keepersofthestonestwo.procedures.EnergiumItemsPowerLockedProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class EnergiumArmorItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 4);
				map.put(ArmorItem.Type.LEGGINGS, 13);
				map.put(ArmorItem.Type.CHESTPLATE, 10);
				map.put(ArmorItem.Type.HELMET, 4);
				map.put(ArmorItem.Type.BODY, 10);
			}), 20, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), () -> Ingredient.of(new ItemStack(PowerModItems.ENERGIUM_INGOT.get())), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("power:energium"))), 0f, 0f);
			registerHelper.register(ResourceLocation.parse("power:energium_armor"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public EnergiumArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends EnergiumArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(34)));
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
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(34)));
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
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(34)));
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
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(34)));
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
