package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.PlantsMasterStartProcedure;

public class PlantsMasterMobEffect extends MobEffect {
	public PlantsMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13395712);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		PlantsMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}