
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import com.esmods.keepersofthestonestwo.procedures.CursedKeyOpenVaultProcedure;

public class CursedKeyItem extends Item {
	public CursedKeyItem(Item.Properties properties) {
		super(properties.stacksTo(16));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		CursedKeyOpenVaultProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
