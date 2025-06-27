package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.RedMagnetEntity;

public class RedMagnetSetTimerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof RedMagnetEntity _datEntSetI)
			_datEntSetI.getEntityData().set(RedMagnetEntity.DATA_time, 600);
	}
}