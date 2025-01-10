
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.PowerMod;

public class WarpMobEffect extends MobEffect {
	public WarpMobEffect() {
		super(MobEffectCategory.HARMFUL, -13108);
		this.addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(PowerMod.MODID, "effect.warp_0"), -0.5, AttributeModifier.Operation.ADD_VALUE);
	}
}
