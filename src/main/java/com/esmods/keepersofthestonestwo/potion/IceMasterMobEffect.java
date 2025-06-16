package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.IceMasterStartProcedure;

public class IceMasterMobEffect extends MobEffect {
	public IceMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16737844);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		IceMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}