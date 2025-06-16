package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.BloodMasterStartProcedure;

public class BloodMasterMobEffect extends MobEffect {
	public BloodMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65536);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		BloodMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}