package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.BlackHoleEntity;

public class BlackHolePriNachalnomPrizyvieSushchnostiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BlackHoleEntity _datEntSetI)
			_datEntSetI.getEntityData().set(BlackHoleEntity.DATA_time, 300);
	}
}