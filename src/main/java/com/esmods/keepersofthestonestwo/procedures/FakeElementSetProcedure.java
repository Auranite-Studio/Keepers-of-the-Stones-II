package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class FakeElementSetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				if (DoubleArgumentType.getDouble(arguments, "element_order") == 1) {
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = StringArgumentType.getString(arguments, "element_name");
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power_recorded = true;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first_timer = DoubleArgumentType.getDouble(arguments, "time") * 20;
						_vars.syncPlayerVariables(entityiterator);
					}
				} else if (DoubleArgumentType.getDouble(arguments, "element_order") == 2) {
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second = StringArgumentType.getString(arguments, "element_name");
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power_recorded = true;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_second_timer = DoubleArgumentType.getDouble(arguments, "time") * 20;
						_vars.syncPlayerVariables(entityiterator);
					}
				} else if (DoubleArgumentType.getDouble(arguments, "element_order") == 3) {
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third = StringArgumentType.getString(arguments, "element_name");
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power_recorded = true;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_third_timer = DoubleArgumentType.getDouble(arguments, "time") * 20;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Fake element has been set under the wheel number " + Math.round(DoubleArgumentType.getDouble(arguments, "element_order")) + " with parameter "
							+ StringArgumentType.getString(arguments, "element_name") + " for " + entityiterator.getDisplayName().getString())), false);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}