/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonestwo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import com.esmods.keepersofthestonestwo.procedures.StoneGetRechargeStateProcedure;
import com.esmods.keepersofthestonestwo.item.FireSwordItem;
import com.esmods.keepersofthestonestwo.item.FireStoneItem;
import com.esmods.keepersofthestonestwo.item.FireArmorItem;
import com.esmods.keepersofthestonestwo.PowerMod;

public class PowerModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PowerMod.MODID);
	public static final DeferredItem<Item> FIRE_STONE;
	public static final DeferredItem<Item> FIRE_ARMOR_HELMET;
	public static final DeferredItem<Item> FIRE_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> FIRE_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> FIRE_ARMOR_BOOTS;
	public static final DeferredItem<Item> FIRE_SWORD;
	static {
		FIRE_STONE = REGISTRY.register("fire_stone", FireStoneItem::new);
		FIRE_ARMOR_HELMET = REGISTRY.register("fire_armor_helmet", FireArmorItem.Helmet::new);
		FIRE_ARMOR_CHESTPLATE = REGISTRY.register("fire_armor_chestplate", FireArmorItem.Chestplate::new);
		FIRE_ARMOR_LEGGINGS = REGISTRY.register("fire_armor_leggings", FireArmorItem.Leggings::new);
		FIRE_ARMOR_BOOTS = REGISTRY.register("fire_armor_boots", FireArmorItem.Boots::new);
		FIRE_SWORD = REGISTRY.register("fire_sword", FireSwordItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	@EventBusSubscriber(Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(FIRE_STONE.get(), ResourceLocation.parse("power:fire_stone_recharge"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) StoneGetRechargeStateProcedure.execute(itemStackToRender));
			});
		}
	}
}