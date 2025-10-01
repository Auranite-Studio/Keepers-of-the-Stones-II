package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.AmberMasterStartProcedure;

public class AmberMasterMobEffect extends MobEffect {
	public AmberMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -26266);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		AmberMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}