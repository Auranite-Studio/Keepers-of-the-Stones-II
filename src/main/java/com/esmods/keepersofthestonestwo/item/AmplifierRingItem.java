
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import com.esmods.keepersofthestonestwo.procedures.AmplifierRingUseProcedure;

public class AmplifierRingItem extends Item {
	public AmplifierRingItem(Item.Properties properties) {
		super(properties.durability(3));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		AmplifierRingUseProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}
}
