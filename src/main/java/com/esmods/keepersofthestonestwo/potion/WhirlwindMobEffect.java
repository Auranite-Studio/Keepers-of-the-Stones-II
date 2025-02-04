
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;

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
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		WhirlwindKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}
