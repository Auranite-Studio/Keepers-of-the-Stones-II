package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;

public class CursedKnightUsloviieProighryvaniiaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.isSprinting() && (entity instanceof CursedKnightEntity _datEntL1 && _datEntL1.getEntityData().get(CursedKnightEntity.DATA_is_attack)) == false;
	}
}
