
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonestwo.procedures.CurseTickEventProcedure;

public class CurseMobEffect extends MobEffect {
	public CurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -10395278);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, "3902ca63-87d5-35de-a32d-06070ae42716", -0.7, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "06095f25-8a04-3174-b233-06e3469b076c", -0.05, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "60e82cc1-a763-3b87-88d0-a81c8212edd7", -0.7, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CurseTickEventProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
