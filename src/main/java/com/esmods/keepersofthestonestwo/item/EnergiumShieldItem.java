package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.procedures.EnergiumItemsPowerLockedProcedure;

public class EnergiumShieldItem extends ShieldItem {
	public EnergiumShieldItem(Item.Properties properties) {
		super(properties.durability(778).repairable(TagKey.create(Registries.ITEM, ResourceLocation.parse("power:energium_shield_repair_items"))));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
	}
}