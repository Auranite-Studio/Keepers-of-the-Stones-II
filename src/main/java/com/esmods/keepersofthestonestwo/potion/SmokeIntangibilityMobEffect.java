
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.SmokeIntangibilityStartProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeIntangibilitySmokeEffectProcedure;
import com.esmods.keepersofthestonestwo.procedures.SmokeIntangibilityEndProcedure;

public class SmokeIntangibilityMobEffect extends MobEffect {
	public SmokeIntangibilityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3355444);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		SmokeIntangibilityStartProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SmokeIntangibilitySmokeEffectProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		SmokeIntangibilityEndProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
