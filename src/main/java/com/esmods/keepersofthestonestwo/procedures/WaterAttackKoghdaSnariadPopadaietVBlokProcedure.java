package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class WaterAttackKoghdaSnariadPopadaietVBlokProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SPLASH, x, y, z, 25, 1, 1, 1, 1);
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR && !((entity.level().dimension()) == Level.NETHER)) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.WATER.defaultBlockState(), 3);
		}
	}
}
