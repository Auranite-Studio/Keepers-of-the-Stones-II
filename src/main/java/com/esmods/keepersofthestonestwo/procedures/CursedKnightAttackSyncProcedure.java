package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;

public class CursedKnightAttackSyncProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof CursedKnightEntity _datEntI ? _datEntI.getEntityData().get(CursedKnightEntity.DATA_attack_anim_sync) : 0) == 1;
	}
}