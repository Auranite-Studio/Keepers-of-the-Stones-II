package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Random;

@EventBusSubscriber
public class OceanPassiveSkills {

	private static final Random RANDOM = new Random();

	private static boolean isInOceanOrBeachBiome(LivingEntity entity) {
		if (entity.level().isClientSide()) return false;
		BlockPos pos = entity.blockPosition();
		var biome = entity.level().getBiome(pos);
		return biome.is(BiomeTags.IS_OCEAN) || biome.is(BiomeTags.IS_BEACH);
	}

	@SubscribeEvent
	public static void onLivingHurt(LivingIncomingDamageEvent event) {
		LivingEntity entity = event.getEntity();

		if (!(entity instanceof Player player)) return;
		if (player.level().isClientSide()) return;

		if (!player.hasEffect(PowerModMobEffects.OCEAN_MASTER)) return;
		if (!isInOceanOrBeachBiome(player)) return;

		if (RANDOM.nextFloat() < 0.15f) {
			float healAmount = player.getMaxHealth() * 0.75f;
			player.heal(healAmount);
		}
	}

	@SubscribeEvent
	public static void onLivingTick(PlayerTickEvent.Post event) {
		LivingEntity entity = event.getEntity();

		if (!(entity instanceof Player player)) return;
		if (player.level().isClientSide()) return;

		boolean hasOceanMaster = player.hasEffect(PowerModMobEffects.OCEAN_MASTER);
		boolean inValidBiome = isInOceanOrBeachBiome(player);

		if (hasOceanMaster && inValidBiome) {
			if (!player.hasEffect(MobEffects.CONDUIT_POWER)) {
				player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 30, 0, false, false));
			}
		} else {
			if (player.hasEffect(MobEffects.CONDUIT_POWER)) {
				player.removeEffect(MobEffects.CONDUIT_POWER);
			}
		}
	}
}