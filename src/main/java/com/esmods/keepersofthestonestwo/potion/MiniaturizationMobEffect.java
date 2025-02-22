
package com.esmods.keepersofthestonestwo.potion;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MiniaturizationMobEffect extends MobEffect {
	public MiniaturizationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26113);
		this.addAttributeModifier(Attributes.MAX_HEALTH, "1fe2a146-294c-3429-a8aa-8d6ee212559d", -0.9, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "241ea6a3-7d59-351e-8dae-57d274c8c88d", -1.5, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "926b0e1b-0503-39be-bce7-39c4e2cc01e1", -2.25, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
