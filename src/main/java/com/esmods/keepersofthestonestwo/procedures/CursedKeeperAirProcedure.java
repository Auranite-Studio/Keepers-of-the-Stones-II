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
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 3, 5, false, false));
		if (entity instanceof CursedKeeperEntity _datEntSetI)
			_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_IA, (int) ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) + 1));
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 15) {
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_two_anim_sync, false);
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 3);
		}
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 44) {
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_windShield, 300);
		}
		if ((entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_IA) : 0) == 344) {
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_IA, 0);
			if (entity instanceof CursedKeeperEntity _datEntSetS)
				_datEntSetS.getEntityData().set(CursedKeeperEntity.DATA_State, "Idle");
			if (entity instanceof CursedKeeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CursedKeeperEntity.DATA_attack_anim_sync, 0);
			if (entity instanceof CursedKeeperEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CursedKeeperEntity.DATA_stage_two_anim_sync, true);
		}
	}
}