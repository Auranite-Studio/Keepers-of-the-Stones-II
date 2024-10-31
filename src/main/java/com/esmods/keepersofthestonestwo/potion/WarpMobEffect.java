
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.WarpPriNalozhieniiEffiektaProcedure;

public class WarpMobEffect extends MobEffect {
	public WarpMobEffect() {
		super(MobEffectCategory.HARMFUL, -13108);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		WarpPriNalozhieniiEffiektaProcedure.execute(entity);
	}
}
