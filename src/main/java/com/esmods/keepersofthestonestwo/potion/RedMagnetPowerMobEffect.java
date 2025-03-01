
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.RedMagnetPowerTickProcedure;

public class RedMagnetPowerMobEffect extends MobEffect {
	public RedMagnetPowerMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65536);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RedMagnetPowerTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
