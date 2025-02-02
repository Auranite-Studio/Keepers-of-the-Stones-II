
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.EnergyMasterStartProcedure;

public class EnergyMasterMobEffect extends MobEffect {
	public EnergyMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13312);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		EnergyMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
