package com.esmods.keepersofthestonestwo;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import org.joml.Vector3f;

public class AutoDodgeEffect {

	private static boolean canTeleportTo(Player player, double x, double y, double z) {
		net.minecraft.core.BlockPos pos1 = new net.minecraft.core.BlockPos((int) x, (int) y, (int) z);
		net.minecraft.core.BlockPos pos2 = new net.minecraft.core.BlockPos((int) x, (int) (y + player.getBbHeight()), (int) z);

		// Проверяем, что оба блока (ноги и голова) находятся в проходимых блоках
		return player.level().getBlockState(pos1).canBeReplaced() &&
				player.level().getBlockState(pos2).canBeReplaced();
	}

	public static void performDodge(Player player) {
		if (player.level().isClientSide) return;

		RandomSource rand = player.getRandom();
		int tries = 10; // Максимум попыток найти безопасное место
		boolean teleported = false;

		for (int i = 0; i < tries; i++) {
			double x = player.getX() + (rand.nextDouble() - 0.5) * 5;
			double z = player.getZ() + (rand.nextDouble() - 0.5) * 5;
			double y = player.getY(); // Можно улучшить — искать по высоте

			// Найти правильную Y-высоту (по земле)
			y = player.level().getHeightmapPos(Heightmap.Types.MOTION_BLOCKING,
					new net.minecraft.core.BlockPos((int) x, (int) y, (int) z)).getY();

			if (canTeleportTo(player, x, y, z)) {
				player.teleportTo(x, y, z);
				teleported = true;
				break;
			}
		}

		if (teleported) {
			ServerLevel level = (ServerLevel) player.level();

			level.playSound(null, player.getX(), player.getY(), player.getZ(),
					net.minecraft.sounds.SoundEvents.ENDERMAN_TELEPORT, player.getSoundSource(), 1.0F, 1.0F);
			
			ParticleOptions particle = new DustParticleOptions(new Vector3f(0.0f, 1.0f, 0.0f), 1.0f); // RGB: зелёный

			for (int i = 0; i < 20; i++) {
				double offsetX = (rand.nextDouble() - 0.5) * 0.5;
				double offsetY = rand.nextDouble() * 2;
				double offsetZ = (rand.nextDouble() - 0.5) * 0.5;

				level.sendParticles(particle,
						player.getX() + offsetX,
						player.getY() + offsetY,
						player.getZ() + offsetZ,
						1, 0, 0, 0, 0);
			}
		}
	}
}