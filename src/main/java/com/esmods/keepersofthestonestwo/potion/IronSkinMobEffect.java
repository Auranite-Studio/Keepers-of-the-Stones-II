package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.IronSkinEffectStartProcedure;

public class IronSkinMobEffect extends MobEffect {
	public IronSkinMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6710887);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		IronSkinEffectStartProcedure.execute(entity);
	}
}