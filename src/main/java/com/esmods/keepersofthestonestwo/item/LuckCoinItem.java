package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.LuckCoinInInventoryProcedure;

public class LuckCoinItem extends Item {
	public LuckCoinItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, EquipmentSlot slot) {
		super.inventoryTick(itemstack, world, entity, slot);
		LuckCoinInInventoryProcedure.execute(entity);
	}
}