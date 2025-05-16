
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.ColorsMasterStartProcedure;

public class ColorsMasterMobEffect extends MobEffect {
	public ColorsMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2868);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		ColorsMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
