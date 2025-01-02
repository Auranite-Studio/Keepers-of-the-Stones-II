package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;

public class CursedSquireAttackSyncProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof CursedSquireEntity _datEntI ? _datEntI.getEntityData().get(CursedSquireEntity.DATA_attack_anim_sync) : 0) == 1;
	}
}
