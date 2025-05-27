
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

import com.esmods.keepersofthestonestwo.procedures.LavaBatteryUseProcedure;

public class LavaBatteryItem extends Item {
	public LavaBatteryItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, display, list, flag);
		list.accept(Component.translatable("item.power.lava_battery.description_0"));
		list.accept(Component.translatable("item.power.lava_battery.description_1"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		LavaBatteryUseProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}
}
