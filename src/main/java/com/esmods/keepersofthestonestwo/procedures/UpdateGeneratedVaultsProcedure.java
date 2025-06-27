package com.esmods.keepersofthestonestwo.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.init.PowerModBlocks;

@EventBusSubscriber
public class UpdateGeneratedVaultsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		boolean updated = false;
		int horizontalRadiusSphere = (int) 5 - 1;
		int verticalRadiusSphere = (int) 5 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == PowerModBlocks.ENERGIUM_VAULT.get()) {
							world.scheduleTick(BlockPos.containing(x + xi, y + i, z + zi), world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)).getBlock(), 0);
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == PowerModBlocks.CURSED_VAULT.get()) {
							world.scheduleTick(BlockPos.containing(x + xi, y + i, z + zi), world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)).getBlock(), 0);
						}
					}
				}
			}
		}
	}
}