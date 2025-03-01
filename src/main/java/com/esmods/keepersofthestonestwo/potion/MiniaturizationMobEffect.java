
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.PowerMod;

public class MiniaturizationMobEffect extends MobEffect {
	public MiniaturizationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26113);
		this.addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.miniaturization_0"), -0.9, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.miniaturization_1"), -1.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.miniaturization_2"), -2.25, AttributeModifier.Operation.ADD_VALUE);
	}
}
