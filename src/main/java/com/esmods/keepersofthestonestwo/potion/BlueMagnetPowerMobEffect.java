
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.BlueMagnetPowerTickProcedure;

public class BlueMagnetPowerMobEffect extends MobEffect {
	public BlueMagnetPowerMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16763956);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		BlueMagnetPowerTickProcedure.execute(level, entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}
