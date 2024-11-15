
package com.esmods.keepersofthestonestwo.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class CreationHoeItem extends HoeItem {
	public CreationHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 5;
			}

			public float getSpeed() {
				return 24f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 0, 0f, new Item.Properties());
	}
}
