
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.GigantizationPriNalozhieniiEffiektaProcedure;

public class GigantizationMobEffect extends MobEffect {
	public GigantizationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26113);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GigantizationPriNalozhieniiEffiektaProcedure.execute(entity);
	}
}
