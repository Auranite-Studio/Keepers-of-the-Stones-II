
package com.esmods.keepersofthestonestwo.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

import com.esmods.keepersofthestonestwo.init.PowerModItems;
import com.esmods.keepersofthestonestwo.init.PowerModEnchantments;

public class IsolationEnchantment extends Enchantment {
	private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("power_isolation",
			item -> Ingredient.of(new ItemStack(PowerModItems.ENERGIUM_PICKAXE.get()), new ItemStack(PowerModItems.ENERGIUM_AXE.get()), new ItemStack(PowerModItems.ENERGIUM_SWORD.get()), new ItemStack(PowerModItems.ENERGIUM_SHOVEL.get()),
					new ItemStack(PowerModItems.ENERGIUM_HOE.get()), new ItemStack(PowerModItems.ENERGIUM_ARMOR_HELMET.get()), new ItemStack(PowerModItems.ENERGIUM_ARMOR_CHESTPLATE.get()), new ItemStack(PowerModItems.ENERGIUM_ARMOR_LEGGINGS.get()),
					new ItemStack(PowerModItems.ENERGIUM_ARMOR_BOOTS.get())).test(new ItemStack(item)));

	public IsolationEnchantment() {
		super(Enchantment.Rarity.UNCOMMON, ENCHANTMENT_CATEGORY, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	}

	@Override
	public int getMinCost(int level) {
		return 1 + level * 10;
	}

	@Override
	public int getMaxCost(int level) {
		return 6 + level * 10;
	}

	@Override
	protected boolean checkCompatibility(Enchantment enchantment) {
		return super.checkCompatibility(enchantment) && !List.of(PowerModEnchantments.REVENGE.get()).contains(enchantment);
	}
}
