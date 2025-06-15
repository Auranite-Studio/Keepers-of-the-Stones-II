package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.SmokeIntangibilityStartProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeIntangibilitySmokeEffectProcedure;

public class SmokeIntangibilityMobEffect extends MobEffect {
	public SmokeIntangibilityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3355444);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		SmokeIntangibilityStartProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		SmokeIntangibilitySmokeEffectProcedure.execute(level, entity.getX(), entity.getY(), entity.getZ());
		return super.applyEffectTick(level, entity, amplifier);
	}
}