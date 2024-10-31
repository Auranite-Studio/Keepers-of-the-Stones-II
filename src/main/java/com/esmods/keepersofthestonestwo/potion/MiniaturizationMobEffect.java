
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.MiniaturizationPriNalozhieniiEffiektaProcedure;

public class MiniaturizationMobEffect extends MobEffect {
	public MiniaturizationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26113);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		MiniaturizationPriNalozhieniiEffiektaProcedure.execute(entity);
	}
}
