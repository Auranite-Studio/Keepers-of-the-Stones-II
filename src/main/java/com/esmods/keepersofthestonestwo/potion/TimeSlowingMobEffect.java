
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.TimeSlowingKazhdyiTikVoVriemiaEffiektaProcedure;

public class TimeSlowingMobEffect extends MobEffect {
	public TimeSlowingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16750900);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TimeSlowingKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
