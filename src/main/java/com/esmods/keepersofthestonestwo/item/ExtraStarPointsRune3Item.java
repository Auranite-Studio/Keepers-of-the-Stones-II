
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class ExtraStarPointsRune3Item extends Item {
	public ExtraStarPointsRune3Item(Item.Properties properties) {
		super(properties.rarity(Rarity.COMMON).stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, display, list, flag);
		list.accept(Component.translatable("item.power.extra_star_points_rune_3.description_0"));
		list.accept(Component.translatable("item.power.extra_star_points_rune_3.description_1"));
		list.accept(Component.translatable("item.power.extra_star_points_rune_3.description_2"));
		list.accept(Component.translatable("item.power.extra_star_points_rune_3.description_3"));
	}
}
