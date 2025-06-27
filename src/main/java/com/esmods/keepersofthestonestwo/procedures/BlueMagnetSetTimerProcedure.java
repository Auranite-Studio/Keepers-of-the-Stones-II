package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.BlueMagnetEntity;

public class BlueMagnetSetTimerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BlueMagnetEntity _datEntSetI)
			_datEntSetI.getEntityData().set(BlueMagnetEntity.DATA_time, 600);
	}
}