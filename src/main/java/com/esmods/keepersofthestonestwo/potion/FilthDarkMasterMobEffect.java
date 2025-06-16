package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.FilthDarkMasterStartProcedure;

public class FilthDarkMasterMobEffect extends MobEffect {
	public FilthDarkMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10092442);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		FilthDarkMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}