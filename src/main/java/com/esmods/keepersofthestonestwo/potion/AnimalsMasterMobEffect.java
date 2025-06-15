package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.AnimalsMasterStartProcedure;

public class AnimalsMasterMobEffect extends MobEffect {
	public AnimalsMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6737152);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		AnimalsMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}