package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.procedures.EnergiumItemsPowerLockedProcedure;

public class EnergiumSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 778, 10f, 0, 5, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:energium_sword_repair_items")));

	public EnergiumSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 9f, -2.4f));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
	}
}