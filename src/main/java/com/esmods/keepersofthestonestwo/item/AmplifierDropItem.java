
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AmplifierDropItem extends Item {
	public AmplifierDropItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
