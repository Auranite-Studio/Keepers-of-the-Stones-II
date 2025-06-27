package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.SmokeMasterStartProcedure;

public class SmokeMasterMobEffect extends MobEffect {
	public SmokeMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6710887);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		SmokeMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}