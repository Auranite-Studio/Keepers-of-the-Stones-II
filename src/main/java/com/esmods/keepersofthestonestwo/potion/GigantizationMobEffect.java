
package com.esmods.keepersofthestonestwo.potion;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class GigantizationMobEffect extends MobEffect {
	public GigantizationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26113);
		this.addAttributeModifier(Attributes.MAX_HEALTH, "297c5c01-0fee-3a46-a4f1-a28144c86291", 9, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "1d94552b-14eb-3ea5-abc6-c3ec2bc27c42", 0.7, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.STEP_HEIGHT_ADDITION.get(), "4597ba39-5a48-3cbd-ab5c-398669586d2a", 1.2, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "489db7a3-f233-3088-b622-b26d0d9a0590", 30, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "7393e637-8fdb-3456-b21e-4d536d202eb3", 45, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
