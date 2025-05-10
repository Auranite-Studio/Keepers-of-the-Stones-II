
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.ShockwaveMasterStartProcedure;

public class ShockwaveMasterMobEffect extends MobEffect {
	public ShockwaveMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -39220);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		ShockwaveMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
