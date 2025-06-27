package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.List;

import com.esmods.keepersofthestonestwo.procedures.ExtraStarPointsRune1UseProcedure;

public class ExtraStarPointsRune1Item extends Item {
	public ExtraStarPointsRune1Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.power.extra_star_points_rune_1.description_0"));
		list.add(Component.translatable("item.power.extra_star_points_rune_1.description_1"));
		list.add(Component.translatable("item.power.extra_star_points_rune_1.description_2"));
		list.add(Component.translatable("item.power.extra_star_points_rune_1.description_3"));
		list.add(Component.translatable("item.power.extra_star_points_rune_1.description_4"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ExtraStarPointsRune1UseProcedure.execute(entity, ar.getObject());
		return ar;
	}
}