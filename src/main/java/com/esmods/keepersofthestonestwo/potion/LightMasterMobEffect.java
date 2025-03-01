
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.LightMasterStartProcedure;

public class LightMasterMobEffect extends MobEffect {
	public LightMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13261);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		LightMasterStartProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
