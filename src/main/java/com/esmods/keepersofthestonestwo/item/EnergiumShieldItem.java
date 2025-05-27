
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.component.BlocksAttacks;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import java.util.Optional;
import java.util.List;

import com.esmods.keepersofthestonestwo.procedures.EnergiumItemsPowerLockedProcedure;

public class EnergiumShieldItem extends ShieldItem {
	public EnergiumShieldItem(Item.Properties properties) {
		super(properties.component(DataComponents.BLOCKS_ATTACKS, createShieldBlockingComponent()).durability(778).repairable(TagKey.create(Registries.ITEM, ResourceLocation.parse("power:energium_shield_repair_items"))));
	}

	private static BlocksAttacks createShieldBlockingComponent() {
		return new BlocksAttacks(1.2f, 0.5f, List.of(new BlocksAttacks.DamageReduction(90.0f, Optional.empty(), 0.0f, 1.0f)), new BlocksAttacks.ItemDamageFunction(4.0f, 1.0f, 1.0f), Optional.of(DamageTypeTags.BYPASSES_SHIELD),
				Optional.of(SoundEvents.SHIELD_BLOCK), Optional.of(SoundEvents.SHIELD_BREAK));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, EquipmentSlot slot) {
		super.inventoryTick(itemstack, world, entity, slot);
		EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
	}
}
