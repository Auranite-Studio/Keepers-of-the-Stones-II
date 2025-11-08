package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class FreakingParsnipItem extends Item {
	public FreakingParsnipItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.15f).build()));
	}
}