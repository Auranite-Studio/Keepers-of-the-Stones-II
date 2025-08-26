package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

import com.esmods.keepersofthestonestwo.procedures.AdditionTimeMasterEffectRune2UseProcedure;

public class AdditionTimeMasterEffectRune2Item extends Item {
	public AdditionTimeMasterEffectRune2Item(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.power.addition_time_master_effect_rune_2.description_0"));
		componentConsumer.accept(Component.translatable("item.power.addition_time_master_effect_rune_2.description_1"));
		componentConsumer.accept(Component.translatable("item.power.addition_time_master_effect_rune_2.description_2"));
		componentConsumer.accept(Component.translatable("item.power.addition_time_master_effect_rune_2.description_3"));
		componentConsumer.accept(Component.translatable("item.power.addition_time_master_effect_rune_2.description_4"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		AdditionTimeMasterEffectRune2UseProcedure.execute(entity, entity.getItemInHand(hand));
		return ar;
	}
}