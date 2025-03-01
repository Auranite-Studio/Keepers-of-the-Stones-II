package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperAttack5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_attack_anim_sync) : 0) == 5;
	}
}
