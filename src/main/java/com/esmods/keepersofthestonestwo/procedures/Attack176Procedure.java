package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class Attack176Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.ability = "spirit_ability_4";
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
