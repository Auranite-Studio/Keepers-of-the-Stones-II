package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class RechargeStoneTickEventProcedure {
	public static void execute(ItemStack itemstack) {
		// Only execute on server side to prevent NBT desync
		Entity entity = itemstack.getEntityRepresentation();
		if (entity == null || entity.level().isClientSide())
			return;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rechargeStone") > 0) {
			final String _tagName = "rechargeStone";
			final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rechargeStone") - 1);
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}
