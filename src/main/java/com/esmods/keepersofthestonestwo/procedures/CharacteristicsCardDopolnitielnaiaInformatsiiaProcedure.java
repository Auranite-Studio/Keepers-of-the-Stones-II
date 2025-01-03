package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class CharacteristicsCardDopolnitielnaiaInformatsiiaProcedure {
	public static String execute(ItemStack itemstack) {
		return !(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("name")).equals("")
				? "\u00A77" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("name")
				: "\u00A77Null";
	}
}
