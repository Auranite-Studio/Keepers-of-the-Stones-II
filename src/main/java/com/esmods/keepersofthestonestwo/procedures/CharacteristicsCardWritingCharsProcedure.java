package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.PowerMod;

public class CharacteristicsCardWritingCharsProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		PowerMod.queueServerWork(1, () -> {
			if ((entity.getPersistentData().getString("ownerCard")).equals(itemstack.getOrCreateTag().getString("owner"))) {
				itemstack.getOrCreateTag().putString("name", (entity.getDisplayName().getString()));
				itemstack.getOrCreateTag().putDouble("level", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level));
				itemstack.getOrCreateTag().putDouble("level_exp", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).level_exp));
				itemstack.getOrCreateTag().putDouble("max_level_exp", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).max_level_exp));
				itemstack.getOrCreateTag().putDouble("damage", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).base_damage_by_lvl));
				itemstack.getOrCreateTag().putDouble("speed", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).speed_char));
				itemstack.getOrCreateTag().putDouble("haste", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).haste_char));
				itemstack.getOrCreateTag().putDouble("jump", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).jump_char));
				itemstack.getOrCreateTag().putDouble("resistance", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).resistance_char));
				itemstack.getOrCreateTag().putString("rank", ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).rank));
			}
		});
	}
}
