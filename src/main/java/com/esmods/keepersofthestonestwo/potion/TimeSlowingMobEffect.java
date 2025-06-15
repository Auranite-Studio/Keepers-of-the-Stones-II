package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.TimeSlowingKazhdyiTikVoVriemiaEffiektaProcedure;

public class TimeSlowingMobEffect extends MobEffect {
	public TimeSlowingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16750900);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		TimeSlowingKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}