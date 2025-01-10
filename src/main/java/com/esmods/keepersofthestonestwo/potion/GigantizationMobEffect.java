
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.PowerMod;

public class GigantizationMobEffect extends MobEffect {
	public GigantizationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26113);
		this.addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.gigantization_0"), 9, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.gigantization_1"), 0.7, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.STEP_HEIGHT, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.gigantization_2"), 1.2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.gigantization_3"), 30, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.gigantization_4"), 45, AttributeModifier.Operation.ADD_VALUE);
	}
}
