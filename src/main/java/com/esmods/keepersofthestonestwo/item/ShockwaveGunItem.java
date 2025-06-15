
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.ShockwaveGunPriVystrielieSnariadomIzPriedmietaProcedure;
import com.esmods.keepersofthestonestwo.procedures.RemoveForbiddenItemProcedure;
import com.esmods.keepersofthestonestwo.entity.ShockwaveGunProjectileEntity;

public class ShockwaveGunItem extends Item {
	public ShockwaveGunItem() {
		super(new Item.Properties());
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 72000;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = InteractionResultHolder.fail(entity.getItemInHand(hand));
		if (entity.getAbilities().instabuild || findAmmo(entity) != ItemStack.EMPTY) {
			ar = InteractionResultHolder.success(entity.getItemInHand(hand));
			entity.startUsingItem(hand);
		}
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RemoveForbiddenItemProcedure.execute(entity, itemstack);
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		if (!world.isClientSide() && entity instanceof ServerPlayer player) {
			ItemStack stack = findAmmo(player);
			if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
				ShockwaveGunProjectileEntity projectile = ShockwaveGunProjectileEntity.shoot(world, entity, world.getRandom());
				if (player.getAbilities().instabuild) {
					projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
				} else {
					if (stack.isDamageableItem()) {
						if (world instanceof ServerLevel serverLevel)
							stack.hurtAndBreak(1, serverLevel, player, _stkprov -> {
							});
					} else {
						stack.shrink(1);
					}
				}
				ShockwaveGunPriVystrielieSnariadomIzPriedmietaProcedure.execute(entity);
			}
		}
	}

	private ItemStack findAmmo(Player player) {
		return new ItemStack(ShockwaveGunProjectileEntity.PROJECTILE_ITEM.getItem());
	}
}
