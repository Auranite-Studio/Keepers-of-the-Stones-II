package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.PowerMod;

public class CharacteristicsCardWritingCharsProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		PowerMod.queueServerWork(1, () -> {
			if ((entity.getPersistentData().getString("ownerCard")).equals(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("owner"))) {
				{
					final String _tagName = "name";
					final String _tagValue = (entity.getDisplayName().getString());
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "level";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).level;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "level_exp";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "max_level_exp";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "damage";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "speed";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).speed_char;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "haste";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).haste_char;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "jump";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).jump_char;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "resistance";
					final double _tagValue = entity.getData(PowerModVariables.PLAYER_VARIABLES).resistance_char;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		});
	}
}
