package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class WheelOpenKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.wheel_open_key_var = true;
				_vars.markSyncDirty();
			}
		} else if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.first_fake_wheel_open_var = true;
				_vars.markSyncDirty();
			}
		}
	}
}