package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.PowerLockStartProcedure;

public class PowerLockMobEffect extends MobEffect {
	public PowerLockMobEffect() {
		super(MobEffectCategory.HARMFUL, -3368704);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		PowerLockStartProcedure.execute(entity);
	}
}