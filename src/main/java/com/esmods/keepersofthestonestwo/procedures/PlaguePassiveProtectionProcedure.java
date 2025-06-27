package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

@EventBusSubscriber
public class PlaguePassiveProtectionProcedure {
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
		double particleRadius = 0;
		double particleAmount = 0;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("plague") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("plague")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("plague") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("plague")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("plague") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("plague")) {
			if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PowerModMobEffects.PLAGUE)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerModMobEffects.PLAGUE);
			}
		}
	}
}