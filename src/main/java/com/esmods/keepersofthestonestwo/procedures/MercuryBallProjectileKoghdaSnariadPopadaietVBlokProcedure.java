package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;
import com.esmods.keepersofthestonestwo.PowerMod;

public class MercuryBallProjectileKoghdaSnariadPopadaietVBlokProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		new Object() {
			void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 4, false, false));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 3, false, false));
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.MERCURY_PARTICLE.get()), x, y, z, 9, 3, 3, 3, 1);
				final int tick2 = ticks;
				PowerMod.queueServerWork(tick2, () -> {
					if (timedlooptotal > timedloopiterator + 1) {
						timedLoop(timedloopiterator + 1, timedlooptotal, tick2);
					}
				});
			}
		}.timedLoop(0, 20, 20);
	}
}
