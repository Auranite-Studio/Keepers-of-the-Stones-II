
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import com.esmods.keepersofthestonestwo.procedures.EnergiumKeyOpenVaultProcedure;

public class EnergiumKeyItem extends Item {
	public EnergiumKeyItem(Item.Properties properties) {
		super(properties.stacksTo(16));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		EnergiumKeyOpenVaultProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
