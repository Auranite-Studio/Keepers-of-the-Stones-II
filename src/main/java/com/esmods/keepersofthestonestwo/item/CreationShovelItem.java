
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;

public class CreationShovelItem extends ShovelItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 5;
		}

		@Override
		public float getSpeed() {
			return 24f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 0;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of();
		}
	};

	public CreationShovelItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 2.25f, -3f)));
	}
}
