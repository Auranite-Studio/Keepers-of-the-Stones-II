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

import java.util.Comparator;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

public class PurpleMushroomSpontannoNaStoronieKliientaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Scaling = 0;
		double particleRadius = 0;
		double particleAmount = 0;
		particleAmount = 8;
		particleRadius = 5;
		for (int index0 = 0; index0 < 3; index0++) {
			for (int index1 = 0; index1 < (int) particleAmount; index1++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (PowerModParticleTypes.MUSHROOM_SPORES.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
							(y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), 1, (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
							(Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), 1);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(particleRadius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (!((entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("mushrooms") || (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("mushrooms")
						|| (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("mushrooms") || (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("mushrooms")
						|| (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("mushrooms") || (entityiterator.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("mushrooms"))) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 4));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 2));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 4));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 4));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 4));
				}
			}
		}
	}
}
