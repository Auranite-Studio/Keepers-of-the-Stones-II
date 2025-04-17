package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class CurseTickEventProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("curseTickDamage") == 60) {
			entity.getPersistentData().putDouble("curseTickDamage", 0);
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 3);
		} else if (entity.getPersistentData().getDouble("curseTickDamage") < 60) {
			entity.getPersistentData().putDouble("curseTickDamage", (entity.getPersistentData().getDouble("curseTickDamage") + 1));
		}
	}
}
