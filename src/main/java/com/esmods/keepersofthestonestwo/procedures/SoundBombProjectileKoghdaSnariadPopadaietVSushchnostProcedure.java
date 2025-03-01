package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class SoundBombProjectileKoghdaSnariadPopadaietVSushchnostProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PowerModMobEffects.STUN.get(), 300, 0, false, false));
	}
}
