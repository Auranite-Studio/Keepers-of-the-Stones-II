package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.EnergiumGolemEntity;

public class EnergiumGolemShootAnimSyncProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof EnergiumGolemEntity _datEntI ? _datEntI.getEntityData().get(EnergiumGolemEntity.DATA_attack_anim_sync) : 0) == 2;
	}
}