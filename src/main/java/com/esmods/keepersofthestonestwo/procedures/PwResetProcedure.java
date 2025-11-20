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
						_vars.base_damage_by_lvl = 6;
						_vars.level_exp = 0;
						_vars.max_level_exp = 100;
						_vars.resistance_char = 0;
						_vars.jump_char = 1;
						_vars.speed_char = 1;
						_vars.haste_char = -1;
						_vars.markSyncDirty();
					}
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = 100;
					_vars.max_power = 100;
					_vars.power_recovery_multiplier = 1;
					_vars.rank = "D";
					_vars.master_effect_duration = 600;
					_vars.recharge_timer = 300;
					_vars.blue_rune_slot = ItemStack.EMPTY.copy();
					_vars.red_rune_slot = ItemStack.EMPTY.copy();
					_vars.green_rune_slot = ItemStack.EMPTY.copy();
					_vars.markSyncDirty();
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