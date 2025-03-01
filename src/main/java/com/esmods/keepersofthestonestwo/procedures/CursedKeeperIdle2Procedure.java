package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperIdle2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) && entity instanceof CursedKeeperEntity _datEntL1 && _datEntL1.getEntityData().get(CursedKeeperEntity.DATA_stage_two_anim_sync);
	}
}
