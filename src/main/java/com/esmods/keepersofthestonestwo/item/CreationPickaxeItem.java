
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CreationPickaxeItem extends PickaxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5, 24f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("power:creation_pickaxe_repair_items")));

	public CreationPickaxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 5f, -2.8f, properties);
	}
}
