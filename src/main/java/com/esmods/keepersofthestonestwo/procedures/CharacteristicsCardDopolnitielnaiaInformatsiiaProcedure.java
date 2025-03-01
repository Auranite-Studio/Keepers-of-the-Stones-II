package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;

public class CharacteristicsCardDopolnitielnaiaInformatsiiaProcedure {
	public static String execute(ItemStack itemstack) {
		return !(itemstack.getOrCreateTag().getString("name")).equals("") ? "\u00A77" + itemstack.getOrCreateTag().getString("name") : "\u00A77Null";
	}
}
