
package com.esmods.keepersofthestonestwo.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MusicDiscCallOfThePastItem extends RecordItem {
	public MusicDiscCallOfThePastItem() {
		super(8, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("power:record.call_of_the_past")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 2960);
	}
}
