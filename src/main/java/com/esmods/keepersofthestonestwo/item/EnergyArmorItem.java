
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

import com.esmods.keepersofthestonestwo.procedures.EnergyArmorKazhdyiTikDliaShliemaProcedure;
import com.esmods.keepersofthestonestwo.procedures.EnergyArmorKazhdyiTikDliaPonozhieiProcedure;
import com.esmods.keepersofthestonestwo.procedures.EnergyArmorKazhdyiTikDliaNaghrudnikaProcedure;
import com.esmods.keepersofthestonestwo.procedures.EnergyArmorKazhdyiTikDliaBotinokProcedure;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class EnergyArmorItem extends ArmorItem {
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
			}), 0, BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), () -> Ingredient.of(), List.of(new ArmorMaterial.Layer(ResourceLocation.parse("power:energy_armor"))), 0f, 0f);
			registerHelper.register(ResourceLocation.parse("power:energy_armor"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public EnergyArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends EnergyArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergyArmorKazhdyiTikDliaShliemaProcedure.execute(entity);
			}
		}
	}

	public static class Chestplate extends EnergyArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergyArmorKazhdyiTikDliaNaghrudnikaProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends EnergyArmorItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergyArmorKazhdyiTikDliaPonozhieiProcedure.execute(entity);
			}
		}
	}

	public static class Boots extends EnergyArmorItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(37)));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				EnergyArmorKazhdyiTikDliaBotinokProcedure.execute(entity);
			}
		}
	}
}
