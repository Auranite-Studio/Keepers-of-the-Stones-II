package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperAirProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 5, false, false));
		entity.getPersistentData().putDouble("IA", (entity.getPersistentData().getDouble("IA") + 1));
		if (entity.getPersistentData().getDouble("IA") == 15) {
			if (entity instanceof CursedKeeperEntity) {
				((CursedKeeperEntity) entity).setAnimation("animation.cursed_keeper.wind_shield");
			}
		}
		if (entity.getPersistentData().getDouble("IA") == 44) {
			entity.getPersistentData().putDouble("windShield", 300);
		}
		if (entity.getPersistentData().getDouble("IA") == 344) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
		}
	}
}
