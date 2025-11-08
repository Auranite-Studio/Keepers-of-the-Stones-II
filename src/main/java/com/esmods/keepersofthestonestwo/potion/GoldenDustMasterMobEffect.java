package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.GoldenDustMasterStartProcedure;

public class GoldenDustMasterMobEffect extends MobEffect {
	public GoldenDustMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13210);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GoldenDustMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}