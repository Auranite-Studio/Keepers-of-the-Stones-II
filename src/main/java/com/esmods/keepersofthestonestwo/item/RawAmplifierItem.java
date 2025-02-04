
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RawAmplifierItem extends Item {
	public RawAmplifierItem(Item.Properties properties) {
		super(properties.rarity(Rarity.COMMON).stacksTo(64));
	}
}
