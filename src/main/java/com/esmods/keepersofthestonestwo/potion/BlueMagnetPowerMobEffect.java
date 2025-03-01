
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.BlueMagnetPowerTickProcedure;

public class BlueMagnetPowerMobEffect extends MobEffect {
	public BlueMagnetPowerMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16763956);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BlueMagnetPowerTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
