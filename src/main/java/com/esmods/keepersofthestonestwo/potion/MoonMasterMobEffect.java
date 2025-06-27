package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.MoonMasterStartProcedure;

public class MoonMasterMobEffect extends MobEffect {
	public MoonMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13369396);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		MoonMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}