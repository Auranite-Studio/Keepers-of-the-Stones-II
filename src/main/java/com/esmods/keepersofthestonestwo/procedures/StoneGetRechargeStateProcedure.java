package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class StoneGetRechargeStateProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rechargeStone") > 0) {
			return 1;
		}
		return 0;
	}
}
