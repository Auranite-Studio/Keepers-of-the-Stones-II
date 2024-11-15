
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;

public class CreationSwordItem extends SwordItem {
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

	public CreationSwordItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 9f, -2.4f)));
	}
}
