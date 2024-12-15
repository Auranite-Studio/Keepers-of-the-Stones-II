package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperWaterProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Grow = 0;
		double Chain = 0;
		double ChainWait = 0;
		double XPar = 0;
		double YPar = 0;
		double loop = 0;
		double Range = 0;
		double particles = 0;
		double ZPar = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 5, false, false));
		entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
		if (entity.getPersistentData().getDouble("IA") == 15) {
			if (entity instanceof CursedKeeperEntity) {
				((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.water_healing");
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 70) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 6, false, false));
		}
		if (entity.getPersistentData().getDouble("IA") == 90) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
		}
	}
}
