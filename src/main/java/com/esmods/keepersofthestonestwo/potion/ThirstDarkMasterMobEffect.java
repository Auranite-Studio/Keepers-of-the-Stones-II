
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.ThirstDarkMasterStartProcedure;

public class ThirstDarkMasterMobEffect extends MobEffect {
	public ThirstDarkMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10092442);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		ThirstDarkMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
