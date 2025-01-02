package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class HitboxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
	}
}
