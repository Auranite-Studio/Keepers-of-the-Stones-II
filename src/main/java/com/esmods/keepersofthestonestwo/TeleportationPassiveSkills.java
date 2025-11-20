package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber
public class TeleportationPassiveSkills {

	private static final int DASH_DURATION = 3 * 20; // 3 сек
	private static final int TELEPORT_RADIUS = 4;    // радиус телепортации
	private static final int CONDITION_RADIUS = 4;   // радиус условия

	// === ПАССИВ 1: Пространственный разлом (работает при АТАКЕ) ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		// Только если урон наносит ИГРОК
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (attacker.level().isClientSide()) return;

		if (!isActive(attacker) || !hasFreeSpace(attacker)) return;

		event.setNewDamage(event.getOriginalDamage() * 1.1f);

		if (attacker.getRandom().nextFloat() < 0.15f) {
			attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, DASH_DURATION, 1, false, false));
		}
	}

	@SubscribeEvent
	public static void onPlayerTakeDamage(LivingIncomingDamageEvent event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (player.level().isClientSide()) return;

		if (!isActive(player) || !hasFreeSpace(player)) return;

		if (player.getRandom().nextFloat() < 0.1f) {
			BlockPos safePos = findSafeTeleportPosition(player);
			if (safePos != null && player.level() instanceof ServerLevel) {
				event.setCanceled(true); // отменить ВЕСЬ урон
				player.teleportTo(safePos.getX() + 0.5, safePos.getY(), safePos.getZ() + 0.5);
			}
		}
	}


	private static boolean isActive(Player player) {
		return player.hasEffect(PowerModMobEffects.TELEPORTATION_MASTER);
	}

	private static boolean hasFreeSpace(Player player) {
		Level level = player.level();
		BlockPos origin = player.blockPosition();
		RandomSource rand = player.getRandom();

		for (int i = 0; i < 30; i++) {
			int x = origin.getX() + rand.nextInt(CONDITION_RADIUS * 2 + 1) - CONDITION_RADIUS;
			int y = origin.getY() + rand.nextInt(7) - 3;
			int z = origin.getZ() + rand.nextInt(CONDITION_RADIUS * 2 + 1) - CONDITION_RADIUS;

			if (isSafePosition(level, new BlockPos(x, y, z))) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSafePosition(Level level, BlockPos pos) {
		if (!level.isInWorldBounds(pos)) return false;

		BlockState feet = level.getBlockState(pos);
		BlockState head = level.getBlockState(pos.above());
		BlockState below = level.getBlockState(pos.below());

		// Проверка: можно стоять
		if (!feet.isAir() && !feet.canBeReplaced()) return false;
		if (!head.isAir() && !head.canBeReplaced()) return false;
		if (below.isAir() || !below.blocksMotion()) return false;

		// Безопасность: нет лавы/огня
		if (feet.is(Blocks.LAVA) || head.is(Blocks.LAVA) ||
				feet.is(Blocks.FIRE) || head.is(Blocks.FIRE)) {
			return false;
		}

		return true;
	}

	private static BlockPos findSafeTeleportPosition(Player player) {
		Level level = player.level();
		BlockPos origin = player.blockPosition();
		RandomSource rand = player.getRandom();

		for (int i = 0; i < 60; i++) {
			double angle = rand.nextDouble() * Math.PI * 2;
			double dist = rand.nextDouble() * TELEPORT_RADIUS;
			int x = origin.getX() + (int) (Mth.cos((float) angle) * dist);
			int z = origin.getZ() + (int) (Mth.sin((float) angle) * dist);
			int y = origin.getY();

			for (int dy = -4; dy <= 4; dy++) {
				BlockPos candidate = new BlockPos(x, y + dy, z);
				if (isSafePosition(level, candidate)) {
					return candidate;
				}
			}
		}
		return null;
	}
}