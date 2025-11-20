package com.esmods.keepersofthestonestwo.procedures;

import org.joml.Vector3f;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.DustParticleOptions;

public class WhiteBombKazhdyiTikPriPoliotieSnariadaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((new DustParticleOptions(new Vector3f(255 / 255.0F, 255 / 255.0F, 255 / 255.0F), 1)), x, y, z, 0, 1, 0);
	}
}