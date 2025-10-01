package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.TeleportationMasterStartProcedure;

public class TeleportationMasterMobEffect extends MobEffect {
	public TeleportationMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16777012);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		TeleportationMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}