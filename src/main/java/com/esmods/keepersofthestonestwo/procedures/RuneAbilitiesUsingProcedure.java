package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class RuneAbilitiesUsingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.PROTECTION_RUNE.get()) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 90) {
				if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PowerModMobEffects.TECHNOBARRIER))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PowerModMobEffects.PROTECTION, 600, 0, false, false));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 90;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).green_rune_slot.getItem() == PowerModItems.SPIN_RUNE.get()) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 90) {
				if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PowerModMobEffects.SPIN))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PowerModMobEffects.SPIN, 600, 0, false, false));
					{
						PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
						_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 90;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
