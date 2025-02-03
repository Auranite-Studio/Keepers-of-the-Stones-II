
package com.esmods.keepersofthestonestwo.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.util.List;

import com.mojang.serialization.MapCodec;

import com.esmods.keepersofthestonestwo.procedures.TornadoStoneUseProcedure;
import com.esmods.keepersofthestonestwo.procedures.StoneGetRechargeStateProcedure;
import com.esmods.keepersofthestonestwo.procedures.RechargeStoneTickEventProcedure;
import com.esmods.keepersofthestonestwo.procedures.GetRechargeInfoProcedure;

public class TornadoStoneItem extends Item {
	public TornadoStoneItem(Item.Properties properties) {
		super(properties.rarity(Rarity.COMMON).stacksTo(1).fireResistant());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		String hoverText = GetRechargeInfoProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		TornadoStoneUseProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RechargeStoneTickEventProcedure.execute(itemstack);
	}

	public record RechargeProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<RechargeProperty> MAP_CODEC = MapCodec.unit(new RechargeProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) StoneGetRechargeStateProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<RechargeProperty> type() {
			return MAP_CODEC;
		}
	}
}
