package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class PlayerTimingSecondFakeElementProcedure {
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
		if (!(entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("0") && entity.getData(PowerModVariables.PLAYER_VARIABLES).power_recorded) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second_timer > 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_second_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second_timer - 1;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_second = "0";
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("0")) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_first_timer = entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second_timer - 1;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_first = entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_second = "0";
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.fake_element_name_second_timer = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}