package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class SpacePassiveAbIlityProcedure {
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
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("space") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("space")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("space") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("space")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("space") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("space")) {
			if (entity.isInLava() || entity.isOnFire()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false));
				entity.clearFire();
			} else if (entity.isInFluidType(Fluids.WATER.getFluidType()) || entity.level().getBlockState(entity.blockPosition()).getBlock() instanceof BubbleColumnBlock) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0, false, false));
			}
		}
	}
}