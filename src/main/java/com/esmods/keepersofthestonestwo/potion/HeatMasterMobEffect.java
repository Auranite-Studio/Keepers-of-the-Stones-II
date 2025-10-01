package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.HeatMasterStartProcedure;

public class HeatMasterMobEffect extends MobEffect {
	public HeatMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -59804);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		HeatMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}