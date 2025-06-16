package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class PowerRecoveryMultiplierSetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power_recovery_multiplier = DoubleArgumentType.getDouble(arguments, "multiplier");
					_vars.syncPlayerVariables(entityiterator);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("The star points recovery multiplier is set to " + Math.round(DoubleArgumentType.getDouble(arguments, "multiplier")) + " for " + entityiterator.getDisplayName().getString())),
							false);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}