package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.entity.Entity;

public class SpiritPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDoubleOr("time", 0) > 0) {
			entity.getPersistentData().putDouble("time", (entity.getPersistentData().getDoubleOr("time", 0) - 1));
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
