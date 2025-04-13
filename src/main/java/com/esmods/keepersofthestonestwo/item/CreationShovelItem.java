
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CreationShovelItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5, 24f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:creation_shovel_repair_items")), 1);

	public CreationShovelItem(Item.Properties properties) {
		super(properties.shovel(TOOL_MATERIAL, 2.25f, -3f));
	}
}
