
package com.esmods.keepersofthestonestwo.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MusicHopeItem extends RecordItem {
	public MusicHopeItem() {
		super(12, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:record.hope")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 4740);
	}
}
