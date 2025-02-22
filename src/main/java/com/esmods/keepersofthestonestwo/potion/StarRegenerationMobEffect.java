
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class StarRegenerationMobEffect extends MobEffect {
	public StarRegenerationMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16763956);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
