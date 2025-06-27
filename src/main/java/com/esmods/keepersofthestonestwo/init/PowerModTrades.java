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
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_1.get()), new ItemStack(Items.EMERALD, 48), new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()), 1, 5, 0.05f));
			event.getTrades().get(1)
					.add(new BasicItemListing(new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_1.get()), new ItemStack(Items.EMERALD, 48), new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()), 1, 5, 0.05f));
			event.getTrades().get(1)
					.add(new BasicItemListing(new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_1.get()), new ItemStack(Items.EMERALD, 48), new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()), 1, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_2.get()), new ItemStack(Items.EMERALD, 64), new ItemStack(PowerModItems.EXTRA_STAR_POINTS_RUNE_3.get()), 1, 5, 0.05f));
			event.getTrades().get(2)
					.add(new BasicItemListing(new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_2.get()), new ItemStack(Items.EMERALD, 64), new ItemStack(PowerModItems.REDUCED_STONE_RECHARGE_TIME_RUNE_3.get()), 1, 5, 0.05f));
			event.getTrades().get(2)
					.add(new BasicItemListing(new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_2.get()), new ItemStack(Items.EMERALD, 64), new ItemStack(PowerModItems.ADDITION_TIME_MASTER_EFFECT_RUNE_3.get()), 1, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PowerModItems.RAW_AMPLIFIER.get(), 2), new ItemStack(Items.EMERALD, 14), new ItemStack(PowerModItems.AMPLIFIER_RING.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(PowerModItems.ENERGIUM_DUST.get(), 16), new ItemStack(Items.EMERALD, 28), 3, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(PowerModItems.UNKNOWN_RUNE.get()), new ItemStack(Items.EMERALD, 52), new ItemStack(PowerModItems.PROTECTION_RUNE.get()), 1, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(PowerModItems.UNKNOWN_RUNE.get()), new ItemStack(Items.EMERALD, 52), new ItemStack(PowerModItems.INVISIBILITY_RUNE.get()), 1, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.PAPER, 3), new ItemStack(Items.EMERALD, 14), new ItemStack(PowerModItems.EMPTY_CHARACTERISTICS_CARD.get()), 3, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PowerModItems.UNKNOWN_RUNE.get()), new ItemStack(Items.EMERALD, 52), new ItemStack(PowerModItems.SPIN_RUNE.get()), 1, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PowerModItems.UNKNOWN_RUNE.get()), new ItemStack(Items.EMERALD, 52), new ItemStack(PowerModItems.DODGING_RUNE.get()), 1, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(PowerModItems.UNKNOWN_RUNE.get()), new ItemStack(Items.EMERALD, 52), new ItemStack(PowerModItems.HEALING_RUNE.get()), 1, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(PowerModItems.FREAKING_PARSNIP.get(), 3), new ItemStack(Items.EMERALD, 5), new ItemStack(PowerModItems.FREAKING_PARSNIP_SOUP.get()), 3, 5, 0.05f));
			event.getTrades().get(4)
					.add(new BasicItemListing(new ItemStack(PowerModItems.ENERGIUM_UPGRADE_SMITHING_TEMPLATE.get()), new ItemStack(Items.EMERALD, 45), new ItemStack(PowerModItems.ENERGIUM_UPGRADE_SMITHING_TEMPLATE.get(), 2), 3, 5, 0.05f));
		}
	}
}