package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.MercuryMasterStartProcedure;

public class MercuryMasterMobEffect extends MobEffect {
	public MercuryMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3355444);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		MercuryMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}