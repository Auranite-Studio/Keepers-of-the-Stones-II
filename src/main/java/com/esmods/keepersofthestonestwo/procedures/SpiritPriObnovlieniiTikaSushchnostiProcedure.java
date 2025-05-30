package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

public class SpiritPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("time") > 0) {
			entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDouble("time") - 1));
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
