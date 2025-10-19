package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class CreationPassiveSkills {

	private static final int HASTE_DURATION = 30; // тиков (1.5 сек) — будет обновляться каждый тик
	private static final int SEARCH_RADIUS = 16;

	private static boolean hasCreationMaster(Player player) {
		return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.CREATION_MASTER);
	}
	private static boolean isNearElementalBlock(Player player) {
		BlockPos center = player.blockPosition();
		int radius = SEARCH_RADIUS;

		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos pos = center.offset(x, y, z);
					BlockState state = player.level().getBlockState(pos);

					if (state.is(Blocks.LAVA) || state.is(Blocks.WATER) || state.is(Blocks.FIRE)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isInMountains(Player player) {
		return player.level().getBiome(player.blockPosition()).is(BiomeTags.IS_MOUNTAIN);
	}

	private static boolean isInCave(Player player) {
		BlockPos pos = player.blockPosition();
		return !player.level().canSeeSky(pos.above()) && pos.getY() < 64;
	}

	private static boolean areConditionsMet(Player player) {
		return isNearElementalBlock(player) || isInMountains(player) || isInCave(player);
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		if (!event.getEntity().level().isClientSide()) {
			if (event.getEntity() instanceof Player player) {
				if (hasCreationMaster(player) && areConditionsMet(player)) {
					event.setNewDamage(event.getOriginalDamage() * 0.8f);
				}
			}
			else if (event.getSource().getEntity() instanceof Player attacker) {
				if (hasCreationMaster(attacker) && areConditionsMet(attacker)) {
					event.setNewDamage(event.getOriginalDamage() * 1.2f);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (player.level().isClientSide()) return;

		if (hasCreationMaster(player) && areConditionsMet(player)) {
			player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, HASTE_DURATION, 2, false, false));
		}
	}
}