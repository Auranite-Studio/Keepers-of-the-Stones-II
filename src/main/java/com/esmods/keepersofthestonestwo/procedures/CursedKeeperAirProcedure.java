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
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_two_anim_sync, false);
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 3);
		}
		if (entity.getPersistentData().getDouble("IA") == 44) {
			entity.getPersistentData().putDouble("windShield", 300);
		}
		if (entity.getPersistentData().getDouble("IA") == 344) {
			entity.getPersistentData().putDouble("IA", 0);
			entity.getPersistentData().putString("State", "Idle");
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 0);
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_two_anim_sync, true);
		}
	}
}