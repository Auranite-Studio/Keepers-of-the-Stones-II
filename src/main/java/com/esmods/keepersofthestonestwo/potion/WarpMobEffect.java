
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class WarpMobEffect extends MobEffect {
	public WarpMobEffect() {
		super(MobEffectCategory.HARMFUL, -13108);
		this.addAttributeModifier(Attributes.MAX_HEALTH, "7e84b1ad-5f89-3000-a0db-03d4481aba6f", -0.5, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
