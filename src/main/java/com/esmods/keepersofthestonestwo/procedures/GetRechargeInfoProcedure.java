package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class GetRechargeInfoProcedure {
	public static String execute(ItemStack itemstack) {
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rechargeStone") > 0
				? "\u00A74" + Component.translatable("power.modinfo.recharge_stone").getString() + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rechargeStone") / 20)
						+ Component.translatable("power.modinfo.recharge_stone.seconds").getString()
				: "\u00A7a" + Component.translatable("power.modinfo.recharge_stone.done").getString();
	}
}
