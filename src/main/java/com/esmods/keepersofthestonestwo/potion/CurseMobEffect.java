package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.procedures.CurseTickEventProcedure;
import com.esmods.keepersofthestonestwo.PowerMod;

public class CurseMobEffect extends MobEffect {
	public CurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -10395278);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.curse_0"), -0.7, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.curse_1"), -0.05, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.curse_2"), -0.7, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		CurseTickEventProcedure.execute(level, entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}