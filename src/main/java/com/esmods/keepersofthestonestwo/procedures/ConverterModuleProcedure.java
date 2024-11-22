package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class ConverterModuleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PowerModVariables.MapVariables.get(world).fv < 1) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.master_effect_duration = 600;
				_vars.syncPlayerVariables(entity);
			}
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.recharge_timer = 300;
				_vars.syncPlayerVariables(entity);
			}
			PowerModVariables.MapVariables.get(world).fv = 1;
			PowerModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
