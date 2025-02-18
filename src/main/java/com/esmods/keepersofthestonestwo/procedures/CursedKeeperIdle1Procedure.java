package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperIdle1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof CursedKeeperEntity _datEntL0 && _datEntL0.getEntityData().get(CursedKeeperEntity.DATA_stage_one_anim_sync)
				&& (entity instanceof CursedKeeperEntity _datEntI ? _datEntI.getEntityData().get(CursedKeeperEntity.DATA_attack_anim_sync) : 0) == 0;
	}
}
