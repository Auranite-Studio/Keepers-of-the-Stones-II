package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class EnhancedAbilitiesNewProcedure {
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
		if (!entity.getData(PowerModVariables.PLAYER_VARIABLES).ability_block && entity.getData(PowerModVariables.PLAYER_VARIABLES).active_power) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 1 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 1, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.jump_char = 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 2, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.jump_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 1 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 0;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 3 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 9) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 1, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 10 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 19) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 2, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 20) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.resistance_char = 3;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 1 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.speed_char = 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 3 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 2, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.speed_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 3, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.speed_char = 3;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 10 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 14) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 0, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = 0;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 15 && entity.getData(PowerModVariables.PLAYER_VARIABLES).level <= 19) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 1, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).level >= 20) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60, 2, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.haste_char = 2;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
