package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class SphereNothingProjectileKazhdyiTikPriPoliotieSnariadaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PowerModMobEffects.VACUUM_MASTER))) {
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 9);
				}
			}
		}
		particleAmount = 9;
		particleRadius = 3;
		for (int index0 = 0; index0 < (int) particleAmount; index0++) {
			world.addParticle((SimpleParticleType) (PowerModParticleTypes.VACUUM_PARTICLE.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
					(z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
					(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
		}
	}
}
