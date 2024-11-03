
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class EnergiumUpgradeSmithingTemplateItem extends Item {
	public EnergiumUpgradeSmithingTemplateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.power.energium_upgrade_smithing_template.upgrade"));
		list.add(Component.literal(""));
		list.add(Component.translatable("item.power.smithing_template.applies_to"));
		list.add(Component.translatable("item.power.energium_upgrade_smithing_template.applies_to"));
		list.add(Component.translatable("item.power.smithing_template.ingredients"));
		list.add(Component.translatable("item.power.energium_upgrade_smithing_template.ingredients"));
	}
}
