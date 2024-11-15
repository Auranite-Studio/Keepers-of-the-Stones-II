package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class SolarSalvoKoghdaSnariadPopadaietVSushchnostProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(5);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 2));
	}
}
