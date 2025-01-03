package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.ArrayList;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@EventBusSubscriber
public class ConfigVariablesToMapVariablesProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (PowerConfigConfiguration.MASTER_EFFECTS_CONTROL_BY_CONFIG.get()) {
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.master_effect_duration = (double) PowerConfigConfiguration.MASTER_EFFECT_DURATION.get();
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					PowerModVariables.PlayerVariables _vars = entityiterator.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.recharge_timer = (double) PowerConfigConfiguration.RECHARGE_TIMER.get();
					_vars.syncPlayerVariables(entityiterator);
				}
				if ((double) PowerConfigConfiguration.MASTER_EFFECT_DURATION.get() == 0 || (double) PowerConfigConfiguration.RECHARGE_TIMER.get() == 0) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.is_set_configurable_zero = true;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.is_set_configurable_zero = false;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
