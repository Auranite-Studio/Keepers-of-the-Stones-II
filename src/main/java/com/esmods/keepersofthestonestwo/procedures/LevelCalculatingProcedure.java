package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@EventBusSubscriber
public class LevelCalculatingProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (PowerConfigConfiguration.ENABLE_LEVELS.get() == true) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level < 20) {
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp >= entity.getData(PowerModVariables.PLAYER_VARIABLES).max_level_exp) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_up_status = true;
						_vars.syncPlayerVariables(entity);
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level_exp = entity.getData(PowerModVariables.PLAYER_VARIABLES).level_exp - 100 * entity.getData(PowerModVariables.PLAYER_VARIABLES).level;
						_vars.syncPlayerVariables(entity);
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.level = entity.getData(PowerModVariables.PLAYER_VARIABLES).level + 1;
						_vars.syncPlayerVariables(entity);
					}
					if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 10) {
						{
							PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
							_vars.base_damage_by_lvl = entity.getData(PowerModVariables.PLAYER_VARIABLES).base_damage_by_lvl + 1;
							_vars.syncPlayerVariables(entity);
						}
					}
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.max_level_exp = 100 * entity.getData(PowerModVariables.PLAYER_VARIABLES).level;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.max_level_exp = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.level_exp = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
