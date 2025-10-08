package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class SpacePassiveSkills {

	private static final Map<UUID, Long> lastAttackTime = new HashMap<>();
	private static final Map<UUID, Integer> attackStreak = new HashMap<>();

	private static final int BLINDNESS_DURATION = 5 * 20;   // 5 сек
	private static final int WEAKNESS_DURATION = 15 * 20;   // 15 сек

	private static boolean isActiveSpaceMaster(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.SPACE_MASTER)) return false;

		Level level = player.level();
		BlockPos pos = player.blockPosition();

		if (level.dimension() == Level.END) {
			return true;
		}

		return level.canSeeSky(pos.above());
	}

	private static boolean isDay(Level level) {
		if (level.dimension() != Level.OVERWORLD) return false;
		long dayTime = level.getDayTime() % 24000;
		return dayTime >= 0 && dayTime < 13000; // примерно день
	}

	private static boolean isNight(Level level) {
		if (level.dimension() != Level.OVERWORLD) return false;
		long dayTime = level.getDayTime() % 24000;
		return dayTime >= 13000;
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (target.level().isClientSide()) return;

		if (!isActiveSpaceMaster(attacker)) return;

		Level level = attacker.level();
		boolean inEnd = level.dimension() == Level.END;
		boolean outdoors = inEnd || level.canSeeSky(attacker.blockPosition().above());

		if (!outdoors) return;

		UUID uuid = attacker.getUUID();
		long currentTime = level.getGameTime();
		long lastTime = lastAttackTime.getOrDefault(uuid, -100L);
		int streak = attackStreak.getOrDefault(uuid, 0);

		if (currentTime - lastTime <= 60) {
			streak++;
		} else {
			streak = 1;
		}

		lastAttackTime.put(uuid, currentTime);
		attackStreak.put(uuid, streak);

		float originalDamage = event.getOriginalDamage();

		if (inEnd || (level.dimension() == Level.OVERWORLD && isDay(level))) {
			if (attacker.getRandom().nextFloat() < 0.1f) {
				event.setNewDamage(originalDamage * 2.0f);
				target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, BLINDNESS_DURATION, 0, false, true));
				return;
			}
		}

		if (inEnd || (level.dimension() == Level.OVERWORLD && isNight(level))) {
			if (streak % 3 == 0) {
				event.setNewDamage(originalDamage * 1.25f);
				target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, WEAKNESS_DURATION, 2, false, true));
			}
		}
	}
}