package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

import com.esmods.keepersofthestonestwo.procedures.CharacteristicsCardPriShchielchkiePKMProcedure;
import com.esmods.keepersofthestonestwo.procedures.CharacteristicsCardDopolnitielnaiaInformatsiiaProcedure;
import com.esmods.keepersofthestonestwo.PowerMod;

public class CharacteristicsCardItem extends Item {
	public CharacteristicsCardItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PowerMod.clientPlayer();
		String hoverText = CharacteristicsCardDopolnitielnaiaInformatsiiaProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				componentConsumer.accept(Component.literal(line));
			}
		}
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		CharacteristicsCardPriShchielchkiePKMProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}
}