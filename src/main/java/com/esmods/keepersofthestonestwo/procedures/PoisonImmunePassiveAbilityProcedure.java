package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

@EventBusSubscriber
public class PoisonImmunePassiveAbilityProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Scaling = 0;
		double particleRadius = 0;
		double particleAmount = 0;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("poison") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("poison")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("poison") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("poison")
				|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("poison") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("poison")) {
			if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.POISON)) {
				particleAmount = 8;
				particleRadius = 2;
				for (int index0 = 0; index0 < (int) particleAmount; index0++) {
					world.addParticle((SimpleParticleType) (PowerModParticleTypes.POISON_PARTICLE.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
							(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
			}
		}
	}
}
