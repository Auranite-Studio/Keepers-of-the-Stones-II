package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.TurretEntity;

public class TurretUsloviieProighryvaniiaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof TurretEntity _datEntL0 && _datEntL0.getEntityData().get(TurretEntity.DATA_is_attack)) == true;
	}
}
