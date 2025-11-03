package com.esmods.keepersofthestonestwo.procedures;

import org.joml.Vector3f;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.DustParticleOptions;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class CurseTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ethernal_curse_points == entity.getData(PowerModVariables.PLAYER_VARIABLES).max_ethernal_curse_points) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.ethernal_curse_points = 0;
				_vars.markSyncDirty();
			}
			particleAmount = 8;
			particleRadius = 2;
			for (int index0 = 0; index0 < 60; index0++) {
				for (int index1 = 0; index1 < (int) particleAmount; index1++) {
					if (world instanceof ServerLevel)
						((ServerLevel) world).sendParticles((new DustParticleOptions(new Vector3f(0 / 255.0F, 255 / 255.0F, 0 / 255.0F), 1)), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
								(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
								(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
				}
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.INDIRECT_MAGIC)), 6);
		} else if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ethernal_curse_points < entity.getData(PowerModVariables.PLAYER_VARIABLES).max_ethernal_curse_points) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.ethernal_curse_points = entity.getData(PowerModVariables.PLAYER_VARIABLES).ethernal_curse_points + 1;
				_vars.markSyncDirty();
			}
		}
	}
}