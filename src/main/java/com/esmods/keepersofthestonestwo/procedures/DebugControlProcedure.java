package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class DebugControlProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.debug = BoolArgumentType.getBool(arguments, "debug_logic");
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Debug mode set is: " + entity.getData(PowerModVariables.PLAYER_VARIABLES).debug)), false);
	}
}