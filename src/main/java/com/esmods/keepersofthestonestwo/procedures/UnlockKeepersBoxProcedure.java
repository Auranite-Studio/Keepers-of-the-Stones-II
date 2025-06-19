package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class UnlockKeepersBoxProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.unlock_keepers_box = BoolArgumentType.getBool(arguments, "unlock_logic");
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					final String _success = ("The unlocking of the box is set to " + BoolArgumentType.getBool(arguments, "unlock_logic") + " for " + entityiterator.getDisplayName().getString());
					final boolean _informAdmins = true;
					arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}