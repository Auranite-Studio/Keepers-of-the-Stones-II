
package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ImmortalityMobEffect extends MobEffect {
	public ImmortalityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3368704);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
