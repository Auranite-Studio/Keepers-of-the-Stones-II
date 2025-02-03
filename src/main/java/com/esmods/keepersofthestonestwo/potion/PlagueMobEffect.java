
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.server.level.ServerLevel;

import com.esmods.keepersofthestonestwo.procedures.InfectionRandomTickProcedure;

public class PlagueMobEffect extends InstantenousMobEffect {
	public PlagueMobEffect() {
		super(MobEffectCategory.HARMFUL, -10092442);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		InfectionRandomTickProcedure.execute(level, entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}
