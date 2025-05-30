
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class EnergiumUpgradeSmithingTemplateItem extends Item {
	public EnergiumUpgradeSmithingTemplateItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, display, list, flag);
		list.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_0"));
		list.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_1"));
		list.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_2"));
		list.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_3"));
		list.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_4"));
		list.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_5"));
	}
}
