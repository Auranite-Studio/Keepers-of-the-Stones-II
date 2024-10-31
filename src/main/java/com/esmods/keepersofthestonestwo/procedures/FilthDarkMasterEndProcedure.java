package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class FilthDarkMasterEndProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:stone_deactivation")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:stone_deactivation")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		DetransformationKeyUseProcedure.execute(world, entity);
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("filth")) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_first = "0";
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("filth")) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_second = "0";
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("filth")) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_third = "0";
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
