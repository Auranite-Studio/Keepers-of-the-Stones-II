
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;

import com.esmods.keepersofthestonestwo.procedures.EnergiumItemsPowerLockedProcedure;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class EnergiumAxeItem extends AxeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 778;
		}

		@Override
		public float getSpeed() {
			return 10f;
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
			return 5;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(PowerModItems.ENERGIUM_INGOT.get()));
		}
	};

	public EnergiumAxeItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 11f, -3.2f)));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EnergiumItemsPowerLockedProcedure.execute(world, entity, itemstack);
	}
}
