package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;

public class StarPointsRecoveryMultiplierDebugProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "global_star_points_recovery_multiplier: "
				+ (new java.text.DecimalFormat("##.#").format((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).power_recovery_multiplier) + " (aem: "
						+ (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PowerModMobEffects.STAR_REGENERATION.get())
								? Math.round((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PowerModMobEffects.STAR_REGENERATION.get()) ? _livEnt.getEffect(PowerModMobEffects.STAR_REGENERATION.get()).getAmplifier() : 0) + 1)
								: 0)
						+ ")");
	}
}
