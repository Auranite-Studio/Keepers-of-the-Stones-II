package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

public class LevelUpSetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				if (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).level < 20 && PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp;
						_vars.markSyncDirty();
					}
					{
						final String _success = ("Level for " + entityiterator.getDisplayName().getString() + " has been raised to " + Math.round(entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).level + 1));
						final boolean _informAdmins = true;
						arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
					}
				} else {
					arguments.getSource().sendFailure(Component.literal(("\u00A7cLevel for " + entityiterator.getDisplayName().getString() + " cannot be raised as it already has the maximum level!")));
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}