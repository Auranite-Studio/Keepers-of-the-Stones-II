package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class StunStopSoundProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < 5; index0++) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.theGame() != null) {
					_ent.theGame().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().theGame(), _ent), "stopsound @s master power:ear_ringing");
				}
			}
		}
	}
}
