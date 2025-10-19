package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.PowerMod;

public class DashMobEffect extends MobEffect {
	public DashMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3355393);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.dash_0"), 0.5, AttributeModifier.Operation.ADD_VALUE);
	}
}