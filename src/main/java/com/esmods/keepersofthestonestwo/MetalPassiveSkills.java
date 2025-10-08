package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.HashMap;

@EventBusSubscriber
public class MetalPassiveSkills {

	private static final Set<Block> METAL_BLOCKS = Set.of(
			Blocks.IRON_ORE,
			Blocks.DEEPSLATE_IRON_ORE,
			Blocks.COPPER_ORE,
			Blocks.DEEPSLATE_COPPER_ORE,
			Blocks.GOLD_ORE,
			Blocks.DEEPSLATE_GOLD_ORE,
			Blocks.ANCIENT_DEBRIS,
			Blocks.NETHER_GOLD_ORE,
			Blocks.RAW_IRON_BLOCK,
			Blocks.RAW_COPPER_BLOCK,
			Blocks.RAW_GOLD_BLOCK,
			Blocks.IRON_BLOCK,
			Blocks.COPPER_BLOCK,
			Blocks.GOLD_BLOCK,
			Blocks.NETHERITE_BLOCK
	);

	private static final Map<UUID, Boolean> nearMetalCache = new HashMap<>();
	private static final Map<UUID, Long> lastCheckTick = new HashMap<>();
	private static final int CHECK_INTERVAL_TICKS = 20; // 1 секунда

	private static final Map<UUID, Long> lastCounterAttack = new HashMap<>();

	private static boolean isNearMetalBlocks(Player player) {
		UUID uuid = player.getUUID();
		Level level = player.level();
		if (level.isClientSide()) return false;

		long currentTick = level.getGameTime();
		if (lastCheckTick.getOrDefault(uuid, 0L) + CHECK_INTERVAL_TICKS <= currentTick) {
			boolean result = checkForMetalBlocks(player);
			nearMetalCache.put(uuid, result);
			lastCheckTick.put(uuid, currentTick);
			return result;
		}
		return nearMetalCache.getOrDefault(uuid, false);
	}

	private static boolean checkForMetalBlocks(Player player) {
		var center = player.blockPosition();
		var level = player.level();

		for (int dx = -16; dx <= 16; dx++) {
			for (int dy = -16; dy <= 16; dy++) {
				for (int dz = -16; dz <= 16; dz++) {
					var block = level.getBlockState(center.offset(dx, dy, dz)).getBlock();
					if (METAL_BLOCKS.contains(block)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@SubscribeEvent
	public static void onIncomingDamage(LivingIncomingDamageEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity instanceof Player player && !player.level().isClientSide()) {
			if (player.hasEffect(PowerModMobEffects.METAL_MASTER) && isNearMetalBlocks(player)) {
				event.setAmount(event.getAmount() * 0.8f);
			}
		}
	}

	// Увеличение наносимого урона на 10%
	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		var source = event.getSource();
		if (source.getEntity() instanceof Player player && !player.level().isClientSide()) {
			if (player.hasEffect(PowerModMobEffects.METAL_MASTER) && isNearMetalBlocks(player)) {
				event.setNewDamage(event.getOriginalDamage() * 1.1f);
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerAttack(AttackEntityEvent event) {
		Player player = event.getEntity();
		if (player.level().isClientSide() || !(player instanceof ServerPlayer serverPlayer)) {
			return;
		}

		if (player.hasEffect(PowerModMobEffects.METAL_MASTER) && isNearMetalBlocks(player)) {
			long now = System.currentTimeMillis();
			long last = lastCounterAttack.getOrDefault(player.getUUID(), 0L);

			if (now - last >= 60_000) {
				if (player.getRandom().nextFloat() < 0.15f) {
					serverPlayer.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, 300, 3, false, false));
					lastCounterAttack.put(player.getUUID(), now);
				}
			}
		}
	}
}