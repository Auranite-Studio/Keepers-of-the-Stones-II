
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AmplifierDropItem extends Item {
	public AmplifierDropItem(Item.Properties properties) {
		super(properties.rarity(Rarity.COMMON).stacksTo(64));
	}
}
