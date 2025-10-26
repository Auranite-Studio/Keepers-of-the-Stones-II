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
public class StarPointsRegenProcedure {
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
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_battery == false && entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power == true
				&& !(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PowerModMobEffects.STAR_REGENERATION)) && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PowerModMobEffects.POWER_LOCK))) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).powerTimer > 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.powerTimer = entity.getData(PowerModVariables.PLAYER_VARIABLES).powerTimer - entity.getData(PowerModVariables.PLAYER_VARIABLES).power_recovery_multiplier;
					_vars.markSyncDirty();
				}
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.powerTimer = 50;
					_vars.markSyncDirty();
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power < entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power + 5;
						_vars.markSyncDirty();
					}
				}
			}
		}
		if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PowerModMobEffects.STAR_REGENERATION)) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).powerTimer > 0) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.powerTimer = entity.getData(PowerModVariables.PLAYER_VARIABLES).powerTimer - entity.getData(PowerModVariables.PLAYER_VARIABLES).power_recovery_multiplier
							* ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PowerModMobEffects.STAR_REGENERATION) ? _livEnt.getEffect(PowerModMobEffects.STAR_REGENERATION).getAmplifier() : 0) + 1);
					_vars.markSyncDirty();
				}
			} else {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.powerTimer = 50;
					_vars.markSyncDirty();
				}
				if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power < entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power) {
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power + 5;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}