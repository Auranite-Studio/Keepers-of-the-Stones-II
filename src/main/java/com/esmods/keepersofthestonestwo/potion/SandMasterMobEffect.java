package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.SandMasterStartProcedure;

public class SandMasterMobEffect extends MobEffect {
	public SandMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -26266);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		SandMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}