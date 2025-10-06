package com.esmods.keepersofthestonestwo; // Замените your.modid на ваш

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Random;

@EventBusSubscriber
public class WaterPassiveSkills {

	private static final Random RANDOM = new Random();

	@SubscribeEvent
	public static void onLivingAttack(LivingDamageEvent.Pre event) {
		LivingEntity entity = event.getEntity();
		if (!(entity instanceof ServerPlayer player)) return;
		if (!player.hasEffect(PowerModMobEffects.WATER_MASTER)) return;

		DamageSource source = event.getSource();
		if (!(source.getEntity() instanceof LivingEntity)) return;

		if (RANDOM.nextFloat() < 0.15f) {
			if (RANDOM.nextBoolean()) {
				float reducedDamage = event.getOriginalDamage() * 0.25f;
				event.setNewDamage(reducedDamage);
			} else {
				float maxHealth = player.getMaxHealth();
				float healAmount = maxHealth * 0.4f;
				player.heal(healAmount);
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (!(player instanceof ServerPlayer)) return;
		if (!player.hasEffect(PowerModMobEffects.WATER_MASTER)) return;


		if (isWaterNearby(player, 8)) {
			if (!player.hasEffect(MobEffects.WATER_BREATHING)) {
				player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
						MobEffects.WATER_BREATHING,
						30,
						0,
						true,
						false,
						false
				));
			}
		}
	}

	private static boolean isWaterNearby(Player player, int radius) {
		BlockPos playerPos = player.blockPosition();
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos pos = playerPos.offset(x, y, z);
					if (player.level().getFluidState(pos).is(FluidTags.WATER)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}