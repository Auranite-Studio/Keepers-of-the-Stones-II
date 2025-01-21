package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

public class PoisonPitTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0.02) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 0.01));
			for (int index0 = 0; index0 < 3; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.POISON_PARTICLE.get()),
							(x + Mth.nextDouble(RandomSource.create(), (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * (-2), Math.abs((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * (-2)))),
							(y + Mth.nextDouble(RandomSource.create(), 0, 0.2)),
							(z + Mth.nextDouble(RandomSource.create(), (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * (-2), Math.abs((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * (-2)))), 3, 0.1, 0.1,
							0.1, 0.1);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 2d), e -> true).stream()
							.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 4, false, false));
						}
					}
				}
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
