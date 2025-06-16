package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.GravityMasterStartProcedure;

public class GravityMasterMobEffect extends MobEffect {
	public GravityMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -26215);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GravityMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}