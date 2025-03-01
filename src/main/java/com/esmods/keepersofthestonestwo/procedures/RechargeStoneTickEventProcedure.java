package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;

public class RechargeStoneTickEventProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("rechargeStone") > 0) {
			itemstack.getOrCreateTag().putDouble("rechargeStone", (itemstack.getOrCreateTag().getDouble("rechargeStone") - 1));
		}
	}
}
