package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.RainMasterStartProcedure;

public class RainMasterMobEffect extends MobEffect {
	public RainMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16751002);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		RainMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}