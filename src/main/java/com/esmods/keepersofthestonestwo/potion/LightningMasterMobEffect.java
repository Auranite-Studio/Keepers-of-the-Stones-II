package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.LightningMasterStartProcedure;

public class LightningMasterMobEffect extends MobEffect {
	public LightningMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3407668);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		LightningMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}