package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CreationSwordItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5, 24f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:creation_sword_repair_items")));

	public CreationSwordItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 9f, -2.4f, properties);
	}
}