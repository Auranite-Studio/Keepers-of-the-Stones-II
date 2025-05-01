
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CreationAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5, 24f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:creation_axe_repair_items")));

	public CreationAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 13f, -3f, properties);
	}
}
