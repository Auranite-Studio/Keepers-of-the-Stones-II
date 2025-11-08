package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.SpeedMasterStartProcedure;

public class SpeedMasterMobEffect extends MobEffect {
	public SpeedMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13382401);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		SpeedMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}