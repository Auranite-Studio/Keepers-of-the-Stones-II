package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class PlayerTimingThirdFakeElementProcedure {
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
		if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("0") && entity.getData(PowerModVariables.PLAYER_VARIABLES).power_recorded) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third_timer > 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_third_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third_timer - 1;
					_vars.markSyncDirty();
				}
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_third = "0";
					_vars.markSyncDirty();
				}
			}
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0")) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_second_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third_timer - 1;
					_vars.fake_element_name_second = entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third;
					_vars.fake_element_name_third = "0";
					_vars.fake_element_name_third_timer = 0;
					_vars.markSyncDirty();
				}
			}
		}
	}
}