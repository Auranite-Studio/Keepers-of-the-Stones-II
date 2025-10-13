package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class TechnologyPassiveSkills {

	private static final int SEARCH_RADIUS = 16;
	private static final int STUN_DURATION = 5 * 20; // 5 секунд в тиках

	// Проверка: активен ли TechnologyMaster
	private static boolean hasTechnologyMaster(Player player) {
		return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.TECHNOLOGY_MASTER);
	}

	// Проверка: рядом есть редстоун или техника
	private static boolean isNearRedstoneOrMechanism(Player player) {
		BlockPos center = player.blockPosition();
		int r = SEARCH_RADIUS;

		for (int x = -r; x <= r; x++) {
			for (int y = -r; y <= r; y++) {
				for (int z = -r; z <= r; z++) {
					BlockPos pos = center.offset(x, y, z);
					BlockState state = player.level().getBlockState(pos);
					var block = state.getBlock();

					if (state.is(BlockTags.REDSTONE_ORES) ||
							block == Blocks.REDSTONE_WIRE ||
							block == Blocks.REDSTONE_TORCH ||
							block == Blocks.REDSTONE_WALL_TORCH ||
							block == Blocks.REPEATER ||
							block == Blocks.COMPARATOR ||
							block == Blocks.LEVER ||
							block == Blocks.NOTE_BLOCK ||
							block == Blocks.DISPENSER ||
							block == Blocks.DROPPER ||
							block == Blocks.PISTON ||
							block == Blocks.STICKY_PISTON ||
							block == Blocks.OBSERVER ||
							block == Blocks.DAYLIGHT_DETECTOR ||
							block == Blocks.TARGET ||
							block == Blocks.SCULK_SENSOR ||
							block == Blocks.CALIBRATED_SCULK_SENSOR) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		if (target.level().isClientSide()) return;

		if (target instanceof Player player) {
			if (hasTechnologyMaster(player) && isNearRedstoneOrMechanism(player)) {
				event.setNewDamage(event.getOriginalDamage() * 0.8f);
			}
		}
		else if (event.getSource().getEntity() instanceof Player attacker) {
			if (hasTechnologyMaster(attacker) && isNearRedstoneOrMechanism(attacker)) {
				// Техношок: 10% шанс на оглушение
				if (attacker.getRandom().nextFloat() < 0.1f) {
					// Наложить кастомный эффект "Оглушение"
					target.addEffect(new MobEffectInstance(
							PowerModMobEffects.STUN, // ← ваш кастомный эффект
							STUN_DURATION,
							0,
							false,
							true
					));
				}
			}
		}
	}
}