
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.VacuumMasterStartProcedure;

public class VacuumMasterMobEffect extends MobEffect {
	public VacuumMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16764109);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		VacuumMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
