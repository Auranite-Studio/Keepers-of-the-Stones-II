package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;

public class CursedKeeperAggroProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof CursedKeeperEntity _datEntL0 && _datEntL0.getEntityData().get(CursedKeeperEntity.DATA_aggro_anim_sync);
	}
}