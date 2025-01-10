
package com.esmods.keepersofthestonestwo.potion;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.PowerMod;

public class TimeStoppedMobEffect extends MobEffect {
	public TimeStoppedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3407821);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_0"), -1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.FLYING_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_1"), -0.4, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_2"), -1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_3"), -0.4, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_4"), -4, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.SNEAKING_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_5"), -0.3, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_6"), -1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_7"), -2.5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.time_stopped_8"), -4.5, AttributeModifier.Operation.ADD_VALUE);
	}
}
