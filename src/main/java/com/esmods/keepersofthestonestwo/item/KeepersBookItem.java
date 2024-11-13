
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class KeepersBookItem extends Item {
	public KeepersBookItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
