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
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

public class RechargeStoneTimeSetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				if (PowerConfigConfiguration.MASTER_EFFECTS_CONTROL_BY_CONFIG.get() == false) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "seconds");
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.recharge_timer = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					if (DoubleArgumentType.getDouble(arguments, "seconds") == 0) {
						{
							boolean _setval = true;
							entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.is_set_configurable_zero = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("The recharge time of the stone is set to " + Math.round(DoubleArgumentType.getDouble(arguments, "seconds")) + " for " + entityiterator.getDisplayName().getString())), false);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7cCommand not executed because config is enabled"), false);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
