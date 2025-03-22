
package com.esmods.keepersofthestonestwo.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MusicDiscAncientMoodItem extends RecordItem {
	public MusicDiscAncientMoodItem() {
		super(9, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:record.ancient_mood")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 4060);
	}
}
