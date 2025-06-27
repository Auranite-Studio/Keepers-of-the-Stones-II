package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

public class PwResetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
				if (PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level = 1;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.base_damage_by_lvl = 6;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = 0;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.max_level_exp = 100;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.resistance_char = 0;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.jump_char = 1;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.speed_char = 1;
						_vars.syncPlayerVariables(entityiterator);
					}
					{
						PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.haste_char = -1;
						_vars.syncPlayerVariables(entityiterator);
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = 100;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_power = 100;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power_recovery_multiplier = 1;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.rank = "D";
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.master_effect_duration = 600;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.recharge_timer = 300;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.blue_rune_slot = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.red_rune_slot = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.green_rune_slot = ItemStack.EMPTY.copy();
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					final String _success = ("All values are reset for " + entityiterator.getDisplayName().getString());
					final boolean _informAdmins = true;
					arguments.getSource().sendSuccess(() -> Component.literal(_success), _informAdmins);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}