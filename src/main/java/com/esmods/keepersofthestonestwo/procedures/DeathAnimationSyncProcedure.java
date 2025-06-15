package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

public class DeathAnimationSyncProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !entity.isAlive();
	}
}