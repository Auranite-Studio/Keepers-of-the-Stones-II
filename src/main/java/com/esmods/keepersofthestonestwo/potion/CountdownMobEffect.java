package com.esmods.keepersofthestonestwo.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CountdownMobEffect extends MobEffect {
	public CountdownMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}
}