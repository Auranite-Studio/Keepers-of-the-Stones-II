package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.FireMasterStartProcedure;

public class FireMasterMobEffect extends MobEffect {
	public FireMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65536);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		FireMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}