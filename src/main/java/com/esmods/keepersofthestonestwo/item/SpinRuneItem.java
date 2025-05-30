
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.List;

import com.esmods.keepersofthestonestwo.procedures.SpinRuneUseProcedure;

public class SpinRuneItem extends Item {
	public SpinRuneItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.power.spin_rune.description_0"));
		list.add(Component.translatable("item.power.spin_rune.description_1"));
		list.add(Component.translatable("item.power.spin_rune.description_2"));
		list.add(Component.translatable("item.power.spin_rune.description_3"));
		list.add(Component.translatable("item.power.spin_rune.description_4"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		SpinRuneUseProcedure.execute(entity, entity.getItemInHand(hand));
		return ar;
	}
}
