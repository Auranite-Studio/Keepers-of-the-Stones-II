package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;

public class CursedKnightUsloviieProighryvaniiaAttackProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof CursedKnightEntity _datEntL0 && _datEntL0.getEntityData().get(CursedKnightEntity.DATA_is_attack)) == true;
	}
}
