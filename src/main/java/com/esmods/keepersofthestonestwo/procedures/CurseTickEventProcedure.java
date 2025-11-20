package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class CurseTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ethernal_curse_points >= entity.getData(PowerModVariables.PLAYER_VARIABLES).max_ethernal_curse_points) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.ethernal_curse_points = 0;
				_vars.markSyncDirty();
			}
			particleAmount = 8;
			particleRadius = 2;
			for (int index0 = 0; index0 < 60; index0++) {
				for (int index1 = 0; index1 < (int) particleAmount; index1++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.CURSED_PORTAL_PARTICLE.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
								(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
								(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
				}
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 6);
		} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ethernal_curse_points < entity.getData(PowerModVariables.PLAYER_VARIABLES).max_ethernal_curse_points) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.ethernal_curse_points = entity.getData(PowerModVariables.PLAYER_VARIABLES).ethernal_curse_points
						+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PowerModMobEffects.CURSE) ? _livEnt.getEffect(PowerModMobEffects.CURSE).getAmplifier() : 0) * 0.25 + 1;
				_vars.markSyncDirty();
			}
		}
	}
}