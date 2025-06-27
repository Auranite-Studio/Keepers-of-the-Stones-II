package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.RedMagnetPowerTickProcedure;

public class RedMagnetPowerMobEffect extends MobEffect {
	public RedMagnetPowerMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65536);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		RedMagnetPowerTickProcedure.execute(level, entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}