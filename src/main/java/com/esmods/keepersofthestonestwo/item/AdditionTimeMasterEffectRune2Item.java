
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

import com.esmods.keepersofthestonestwo.procedures.AdditionTimeMasterEffectRune2UseProcedure;

public class AdditionTimeMasterEffectRune2Item extends Item {
	public AdditionTimeMasterEffectRune2Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.power.addition_time_master_effect_rune_2.description_0"));
		list.add(Component.translatable("item.power.addition_time_master_effect_rune_2.description_1"));
		list.add(Component.translatable("item.power.addition_time_master_effect_rune_2.description_2"));
		list.add(Component.translatable("item.power.addition_time_master_effect_rune_2.description_3"));
		list.add(Component.translatable("item.power.addition_time_master_effect_rune_2.description_4"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		AdditionTimeMasterEffectRune2UseProcedure.execute(entity, ar.getObject());
		return ar;
	}
}
