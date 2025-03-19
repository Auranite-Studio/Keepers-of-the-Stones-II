
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.LavaMasterStartProcedure;

public class LavaMasterMobEffect extends MobEffect {
	public LavaMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -39424);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		LavaMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
