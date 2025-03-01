package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class GetRechargeInfoProcedure {
	public static String execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("rechargeStone") > 0
				? "\u00A74" + Component.translatable("power.modinfo.recharge_stone").getString() + Math.round(itemstack.getOrCreateTag().getDouble("rechargeStone") / 20) + Component.translatable("power.modinfo.recharge_stone.seconds").getString()
				: "\u00A7a" + Component.translatable("power.modinfo.recharge_stone.done").getString();
	}
}
