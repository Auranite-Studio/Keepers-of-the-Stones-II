package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.MusicMasterStartProcedure;

public class MusicMasterMobEffect extends MobEffect {
	public MusicMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10066177);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		MusicMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}