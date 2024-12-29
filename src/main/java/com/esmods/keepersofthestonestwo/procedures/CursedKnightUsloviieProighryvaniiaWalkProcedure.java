package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

public class CursedKnightUsloviieProighryvaniiaWalkProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D && !entity.isSprinting();
	}
}
