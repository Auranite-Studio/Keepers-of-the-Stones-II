package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

public class DestructionBallProjectileKazhdyiTikPriPoliotieSnariadaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (PowerModParticleTypes.RUNES_OF_DESTRUCTION.get()), x, y, z, 0, 1, 0);
	}
}
