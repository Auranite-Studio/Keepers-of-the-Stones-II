package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class FakeElementsTimerDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "fake_elements_timer: " + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first_timer / 20) + "/" + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second_timer / 20)
				+ "/" + Math.round(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third_timer / 20);
	}
}