package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.BlueFlameMasterStartProcedure;

public class BlueFlameMasterMobEffect extends MobEffect {
	public BlueFlameMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16737793);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		BlueFlameMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}