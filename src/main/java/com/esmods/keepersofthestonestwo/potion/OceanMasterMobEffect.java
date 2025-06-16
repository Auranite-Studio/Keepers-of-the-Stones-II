package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.OceanMasterStartProcedure;

public class OceanMasterMobEffect extends MobEffect {
	public OceanMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16737895);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		OceanMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}