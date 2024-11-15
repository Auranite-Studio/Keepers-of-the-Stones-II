
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

import com.esmods.keepersofthestonestwo.procedures.SmokeArmorKazhdyiTikDliaShliemaProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeArmorKazhdyiTikDliaPonozhieiProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeArmorKazhdyiTikDliaNaghrudnikaProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeArmorKazhdyiTikDliaBotinokProcedure;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class SmokeArmorItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 3);
				map.put(ArmorItem.Type.LEGGINGS, 6);
				map.put(ArmorItem.Type.CHESTPLATE, 8);
				map.put(ArmorItem.Type.HELMET, 3);
				map.put(ArmorItem.Type.BODY, 8);
			}), 0, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), () -> Ingredient.of(), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("power:smoke_armor"))), 0f, 0f);
			registerHelper.register(ResourceLocation.parse("power:smoke_armor"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public SmokeArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends SmokeArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				SmokeArmorKazhdyiTikDliaShliemaProcedure.execute(entity);
			}
		}
	}

	public static class Chestplate extends SmokeArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				SmokeArmorKazhdyiTikDliaNaghrudnikaProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends SmokeArmorItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				SmokeArmorKazhdyiTikDliaPonozhieiProcedure.execute(entity);
			}
		}
	}

	public static class Boots extends SmokeArmorItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				SmokeArmorKazhdyiTikDliaBotinokProcedure.execute(entity);
			}
		}
	}
}
