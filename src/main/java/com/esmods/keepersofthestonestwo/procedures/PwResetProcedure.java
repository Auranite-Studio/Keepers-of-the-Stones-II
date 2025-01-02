package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

public class PwResetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				if (PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
					{
						double _setval = 1;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.level = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = 6;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.base_damage_by_lvl = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = 0;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.level_exp = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = 100;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.max_level_exp = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = 0;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.resistance_char = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = 1;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jump_char = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = 1;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.speed_char = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = -1;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.haste_char = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				}
				{
					double _setval = 100;
					entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.power = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					double _setval = 100;
					entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.max_power = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					double _setval = 1;
					entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.power_recovery_multiplier = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					String _setval = "D";
					entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.rank = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				if (PowerConfigConfiguration.MASTER_EFFECTS_CONTROL_BY_CONFIG.get() == false) {
					{
						double _setval = 600;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.master_effect_duration = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
					{
						double _setval = 300;
						entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.recharge_timer = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("All values are reset for " + entityiterator.getDisplayName().getString())), false);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
