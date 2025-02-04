
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonestwo.procedures.EnergiumItemsPowerLockedProcedure;

public class EnergiumShovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 778, 10f, 0, 5, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:energium_shovel_repair_items")));

	public EnergiumShovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 4.25f, -3f, properties);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
	}
}
