package com.esmods.keepersofthestonestwo.item;

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
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_0"));
		componentConsumer.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_1"));
		componentConsumer.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_2"));
		componentConsumer.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_3"));
		componentConsumer.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_4"));
		componentConsumer.accept(Component.translatable("item.power.energium_upgrade_smithing_template.description_5"));
	}
}