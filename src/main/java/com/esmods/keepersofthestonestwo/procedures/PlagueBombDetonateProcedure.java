package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class PlagueBombDetonateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double particleRadius = 0;
		double particleAmount = 0;
		particleAmount = 300;
		particleRadius = 10;
		for (int index0 = 0; index0 < (int) particleAmount; index0++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.PLAGUE_PARTICLE_TWO.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius),
						(y + 0 + Mth.nextDouble(RandomSource.create(), 0, 5) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius), 1, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.PLAGUE_PARTICLE_THREE.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius),
						(y + 0 + Mth.nextDouble(RandomSource.create(), 0, 5) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius), 1, 0, 0, 0, 1);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PowerModMobEffects.PLAGUE.get(), 3600, 0));
			}
		}
	}
}
