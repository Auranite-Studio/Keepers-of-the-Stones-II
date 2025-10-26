package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class PlayerTimingFistFakeElementProcedure {
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
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power_recorded) {
			if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first_timer > 0) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first_timer - 1;
						_vars.markSyncDirty();
					}
				} else {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.fake_element_name_first = "0";
						_vars.markSyncDirty();
					}
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first_timer == 0 && entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second_timer == 0
					&& entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third_timer == 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_first = "0";
					_vars.power_recorded = false;
					_vars.markSyncDirty();
				}
			}
		}
	}
}