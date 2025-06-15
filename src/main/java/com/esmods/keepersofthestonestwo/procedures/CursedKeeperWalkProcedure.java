package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperWalkProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D && !entity.isSprinting() && (entity instanceof CursedKeeperEntity _datEntL2 && _datEntL2.getEntityData().get(CursedKeeperEntity.DATA_stage_one_anim_sync)) == false
				&& (entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_attack_anim_sync) : 0) == 0
				&& (entity instanceof CursedKeeperEntity _datEntL4 && _datEntL4.getEntityData().get(CursedKeeperEntity.DATA_aggro_anim_sync)) == false
				&& (entity instanceof CursedKeeperEntity _datEntL5 && _datEntL5.getEntityData().get(CursedKeeperEntity.DATA_fall_anim_sync)) == false;
	}
}