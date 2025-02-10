
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.PlagueMasterStartProcedure;

public class PlagueMasterMobEffect extends MobEffect {
	public PlagueMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13434829);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		PlagueMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
