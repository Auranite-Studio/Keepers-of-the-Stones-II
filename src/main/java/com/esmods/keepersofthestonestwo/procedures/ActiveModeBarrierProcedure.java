package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

public class ActiveModeBarrierProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double r = 0;
		double a = 0;
		double b = 0;
		{
			final Vec3 _center = new Vec3(x, (y + 1), z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Arrow) {
					entity.getPersistentData().putBoolean("barrier", true);
				}
			}
		}
		r = 1.5;
		a = 0;
		b = 90;
		for (int index0 = 0; index0 < 30; index0++) {
			for (int index1 = 0; index1 < 16; index1++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.TECHNOBARRIER_PARTICLE.get()), (x - r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a))), ((y + 1) - r * Math.sin(Math.toRadians(b))),
							(z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))), 1, 0, 0, 0, 0);
				b = b + 12;
			}
			b = 90;
			a = a + 12;
			{
				final Vec3 _center = new Vec3(x, (y + 1), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entity.getPersistentData().getBoolean("barrier") != true) {
						if (!(entityiterator == entity)) {
							entityiterator.setDeltaMovement(new Vec3((1.5 * entity.getDeltaMovement().x()), (1.5 * entity.getDeltaMovement().y()), (1.5 * entity.getLookAngle().z)));
						}
					}
				}
			}
		}
	}
}
