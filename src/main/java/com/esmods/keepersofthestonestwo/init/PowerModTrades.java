
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class PowerModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType().equals(PowerModVillagerProfessions.RUNOLOGIST.getKey())) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(PowerModItems.EMPTY_RUNE.get()), new ItemStack(Items.EMERALD, 32), new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()), 1, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(PowerModItems.EMPTY_RUNE.get()), new ItemStack(Items.EMERALD, 32), new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get()), 1, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(PowerModItems.EMPTY_RUNE.get()), new ItemStack(Items.EMERALD, 32), new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get()), 1, 10, 0.05f));
		}
	}
}
