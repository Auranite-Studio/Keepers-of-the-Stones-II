
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.TimeStoppedPriNalozhieniiEffiektaProcedure;
import com.esmods.keepersofthestonestwo.procedures.TimeStoppedPriIstiechieniiEffiektaProcedure;
import com.esmods.keepersofthestonestwo.procedures.TimeStoppedKazhdyiTikVoVriemiaEffiektaProcedure;

public class TimeStoppedMobEffect extends MobEffect {
	public TimeStoppedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3407821);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		TimeStoppedPriNalozhieniiEffiektaProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TimeStoppedKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		TimeStoppedPriIstiechieniiEffiektaProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
