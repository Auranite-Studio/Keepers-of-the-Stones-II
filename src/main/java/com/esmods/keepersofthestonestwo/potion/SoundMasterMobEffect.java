package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.SoundMasterStartProcedure;

public class SoundMasterMobEffect extends MobEffect {
	public SoundMasterMobEffect() {
		super(MobEffectCategory.NEUTRAL, -6750055);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		SoundMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}