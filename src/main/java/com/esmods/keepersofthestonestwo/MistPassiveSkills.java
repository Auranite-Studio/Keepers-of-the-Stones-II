package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class MistPassiveSkills {

	private static final int REGEN_DURATION = 15 * 20;
	private static final int REGEN_COOLDOWN = 45 * 20;
	private static final int WATER_RADIUS = 8;

	private static final Map<UUID, Long> lastRegenTime = new HashMap<>();

	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.MIST_MASTER)) return false;

		Level level = player.level();
		BlockPos pos = player.blockPosition();

		Biome biome = level.getBiome(pos).value();
		if (biome.getModifiedClimateSettings().downfall() >= 0.6f) {
			return true;
		}

		for (int x = -WATER_RADIUS; x <= WATER_RADIUS; x++) {
			for (int y = -WATER_RADIUS; y <= WATER_RADIUS; y++) {
				for (int z = -WATER_RADIUS; z <= WATER_RADIUS; z++) {
					if (level.getBlockState(pos.offset(x, y, z)).is(Blocks.WATER)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isMorning(Player player) {
		long dayTime = player.level().getDayTime() % 24000;
		return dayTime >= 1000 && dayTime <= 12000; // от рассвета до полудня
	}

	@SubscribeEvent
	public static void onPlayerTakeDamage(LivingIncomingDamageEvent event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!isActive(player)) return;

		if (player.getRandom().nextFloat() < 0.1f) {
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (player.level().isClientSide()) return;
		if (!isActive(player)) return;
		if (!isMorning(player)) return;

		UUID playerId = player.getUUID();
		long currentTime = player.level().getGameTime();
		Long lastTime = lastRegenTime.get(playerId);

		if (lastTime == null || (currentTime - lastTime) >= REGEN_COOLDOWN) {
			player.addEffect(new MobEffectInstance(
					MobEffects.REGENERATION,
					REGEN_DURATION,
					1,
					false,
					true
			));
			lastRegenTime.put(playerId, currentTime);
		}
	}
}