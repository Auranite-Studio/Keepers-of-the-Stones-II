package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.init.PowerModEntities;
import com.esmods.keepersofthestonestwo.PowerMod;

public class SpawnPoisonPitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PowerMod.queueServerWork(1, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PowerModEntities.POISON_PIT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		});
	}
}
