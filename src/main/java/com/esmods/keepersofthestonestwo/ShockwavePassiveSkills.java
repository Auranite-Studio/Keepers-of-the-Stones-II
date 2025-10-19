package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class ShockwavePassiveSkills {

	private static final long COMBO_RESET_TIME = 9 * 20; // 9 сек
	private static final Map<UUID, Integer> attackStreak = new HashMap<>();
	private static final Map<UUID, Long> lastAttackTime = new HashMap<>();

	private static boolean isStandingOnSolidBlock(Player player) {
		BlockPos pos = player.blockPosition().below();
		BlockState state = player.level().getBlockState(pos);
		return !state.isAir() && state.blocksMotion();
	}

	private static boolean isActive(Player player) {
		return !player.level().isClientSide() &&
				player.hasEffect(PowerModMobEffects.SHOCKWAVE_MASTER) &&
				isStandingOnSolidBlock(player);
	}

	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity target)) return;
		if (!isActive(attacker)) return;

		UUID id = attacker.getUUID();
		long now = attacker.level().getGameTime();
		long last = lastAttackTime.getOrDefault(id, -100L);
		int streak = attackStreak.getOrDefault(id, 0);

		if (now - last <= COMBO_RESET_TIME) {
			streak++;
		} else {
			streak = 1;
		}

		lastAttackTime.put(id, now);
		attackStreak.put(id, streak);

		if (streak % 3 == 0) {
			// +50% урона
			event.setNewDamage(event.getOriginalDamage() * 1.5f);

			// Отталкивание цели
			Vec3 dir = target.position().subtract(attacker.position()).normalize();
			if (dir.lengthSqr() < 1e-6) dir = new Vec3(0, 0, 1);
			target.push(dir.x * 1.2, 0.4, dir.z * 1.2);
			target.hurtMarked = true;
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!player.hasEffect(PowerModMobEffects.SHOCKWAVE_MASTER)) return;
		if (!isStandingOnSolidBlock(player)) return;

		// Иммунитет к отталкиванию: сбрасываем внешнее ускорение по горизонтали
		Vec3 motion = player.getDeltaMovement();
		player.setDeltaMovement(motion.x * 0.6, motion.y, motion.z * 0.6);
	}
}