
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.EarthMasterStartProcedure;

public class EarthMasterMobEffect extends MobEffect {
	public EarthMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10079488);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		EarthMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
