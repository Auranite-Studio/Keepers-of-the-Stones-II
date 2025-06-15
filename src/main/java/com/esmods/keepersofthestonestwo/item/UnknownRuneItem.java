package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

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

import com.esmods.keepersofthestonestwo.procedures.UnknownRuneManifestProcedure;

public class UnknownRuneItem extends Item {
	public UnknownRuneItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, display, list, flag);
		list.accept(Component.translatable("item.power.unknown_rune.description_0"));
		list.accept(Component.translatable("item.power.unknown_rune.description_1"));
		list.accept(Component.translatable("item.power.unknown_rune.description_2"));
		list.accept(Component.translatable("item.power.unknown_rune.description_3"));
		list.accept(Component.translatable("item.power.unknown_rune.description_4"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		UnknownRuneManifestProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}
}