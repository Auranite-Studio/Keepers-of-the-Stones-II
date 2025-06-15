package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.PowerMod;

public class MusicDiscCallOfThePastItem extends Item {
	public MusicDiscCallOfThePastItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "music_disc_call_of_the_past"))));
	}
}