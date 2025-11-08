package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.WhirlwindKazhdyiTikVoVriemiaEffiektaProcedure;

public class WhirlwindMobEffect extends MobEffect {
	public WhirlwindMobEffect() {
		super(MobEffectCategory.HARMFUL, -10066330);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		WhirlwindKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}