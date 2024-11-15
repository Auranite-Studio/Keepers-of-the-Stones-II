package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;
import java.util.Comparator;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class InfectionRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double debaf_tick = 0;
		if (entity.getPersistentData().getDouble("debafTicking") == 0) {
			if (Math.random() <= 0.1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1, false, false));
			} else if (Math.random() <= 0.2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1, false, false));
			} else if (Math.random() <= 0.3) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 1, false, false));
			} else if (Math.random() <= 0.4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, false, false));
			} else if (Math.random() <= 0.5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 1, false, false));
			} else if (Math.random() > 0.5) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(PowerModMobEffects.PLAGUE, 3600, 0, false, true));
						}
					}
				}
			}
			entity.getPersistentData().putDouble("debafTicking", 200);
		} else {
			entity.getPersistentData().putDouble("debafTicking", (entity.getPersistentData().getDouble("debafTicking") - 1));
		}
	}
}
