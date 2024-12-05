package com.esmods.keepersofthestonestwo.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.ArrayList;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;

@Mod.EventBusSubscriber
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
					double _setval = (double) PowerConfigConfiguration.MASTER_EFFECT_DURATION.get();
					entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.master_effect_duration = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				{
					double _setval = (double) PowerConfigConfiguration.RECHARGE_TIMER.get();
					entityiterator.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.recharge_timer = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				if ((double) PowerConfigConfiguration.MASTER_EFFECT_DURATION.get() == 0 || (double) PowerConfigConfiguration.RECHARGE_TIMER.get() == 0) {
					{
						boolean _setval = true;
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.is_set_configurable_zero = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				{
					boolean _setval = false;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.is_set_configurable_zero = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
