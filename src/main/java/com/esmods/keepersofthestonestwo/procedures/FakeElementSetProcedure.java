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
						String _setval = StringArgumentType.getString(arguments, "element_name");
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						boolean _setval = true;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.power_recorded = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "time") * 20;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_first_timer = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (DoubleArgumentType.getDouble(arguments, "element_order") == 2) {
					{
						String _setval = StringArgumentType.getString(arguments, "element_name");
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						boolean _setval = true;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.power_recorded = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "time") * 20;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_second_timer = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if (DoubleArgumentType.getDouble(arguments, "element_order") == 3) {
					{
						String _setval = StringArgumentType.getString(arguments, "element_name");
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						boolean _setval = true;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.power_recorded = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "time") * 20;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fake_element_name_third_timer = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
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
