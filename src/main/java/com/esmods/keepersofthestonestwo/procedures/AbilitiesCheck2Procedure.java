package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class AbilitiesCheck2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).ability).equals("rune_ability")) {
			RuneAbilitiesUsingProcedure.execute(world, x, y, z, entity);
		}
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("heat") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("heat")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("heat") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("heat")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("heat") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("heat")) {
			HeatSpecialAttackProcedure.execute(world, x, y, z, entity);
		}
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("shockwave") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("shockwave")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("shockwave") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("shockwave")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("shockwave") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("shockwave")) {
			ShockwaveSpecialAttackProcedure.execute(world, x, y, z, entity);
		}
	}
}
