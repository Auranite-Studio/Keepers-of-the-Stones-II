
package com.esmods.keepersofthestonestwo.potion;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TimeStoppedMobEffect extends MobEffect {
	public TimeStoppedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3407821);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "3fc180cb-b22b-345e-9b0d-516a22834cfd", -1, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.FLYING_SPEED, "86e05006-1be0-32a7-aa97-d1863785e4c9", -0.4, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, "964d3e26-5288-3827-842b-c003d9507ee4", -1, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.SWIM_SPEED.get(), "2fd7de0f-bd8c-301e-bca2-818e02b382d9", -0.4, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, "f8eae17e-22e9-3d43-851d-f40d80fd1acc", -4, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.MAX_HEALTH, "f591de89-2e27-3d06-a034-ec205e0a927d", -0.3, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.MAX_HEALTH, "a52dfe0a-9a17-3739-8b27-30ba3f893f86", -1, AttributeModifier.Operation.MULTIPLY_BASE);
		this.addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "f7bd12ce-63a7-3405-9abd-8ba0e420daa3", -2.5, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "a921422f-89d8-3233-806a-26685f34ffe1", -4.5, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
