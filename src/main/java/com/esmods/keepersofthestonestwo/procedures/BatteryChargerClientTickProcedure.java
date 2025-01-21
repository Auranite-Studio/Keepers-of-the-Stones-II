package com.esmods.keepersofthestonestwo.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.init.PowerModParticleTypes;

public class BatteryChargerClientTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double fireHeight = 0;
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "craftingProgress") > 0) {
			if (Math.random() < 0.2) {
				world.addParticle((SimpleParticleType) (PowerModParticleTypes.ENERGY_SPARK.get()), (x + 0.5), (y + 1), (z + 0.5), 0.5, 0.1, 0.5);
				world.addParticle((SimpleParticleType) (PowerModParticleTypes.ENERGY_SPARK.get()), (x + 0.5), (y + 1), (z + 0.5), (-0.5), 0.1, 0.5);
				world.addParticle((SimpleParticleType) (PowerModParticleTypes.ENERGY_SPARK.get()), (x + 0.5), (y + 1), (z + 0.5), 0.5, 0.1, (-0.5));
				world.addParticle((SimpleParticleType) (PowerModParticleTypes.ENERGY_SPARK.get()), (x + 0.5), (y + 1), (z + 0.5), (-0.5), 0.1, (-0.5));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, y), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:magnetic_waves")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, y, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:magnetic_waves")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}
}
