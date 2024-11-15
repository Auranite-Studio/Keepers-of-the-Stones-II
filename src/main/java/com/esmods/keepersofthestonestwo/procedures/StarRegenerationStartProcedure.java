package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class StarRegenerationStartProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PowerModMobEffects.STAR_REGENERATION.get()) ? _livEnt.getEffect(PowerModMobEffects.STAR_REGENERATION.get()).getAmplifier() : 0) + 1) * 2;
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.power_recovery_multiplier = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
