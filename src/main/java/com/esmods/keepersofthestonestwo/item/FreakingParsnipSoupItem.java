
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class FreakingParsnipSoupItem extends Item {
	public FreakingParsnipSoupItem(Item.Properties properties) {
		super(properties.stacksTo(1).food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.8f).build()).usingConvertsTo(Items.BOWL));
	}
}
