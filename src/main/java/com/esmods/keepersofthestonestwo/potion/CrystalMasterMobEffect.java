
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.CrystalMasterStartProcedure;

public class CrystalMasterMobEffect extends MobEffect {
	public CrystalMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6749953);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		CrystalMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
