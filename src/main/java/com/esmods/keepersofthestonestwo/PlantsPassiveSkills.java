package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class PlantsPassiveSkills {

	private static boolean isInValidBiome(Player player) {
		var biome = player.level().getBiome(player.blockPosition());
		return biome.is(Tags.Biomes.IS_FOREST)
				|| biome.is(Tags.Biomes.IS_PLAINS)
				|| biome.is(Tags.Biomes.IS_TAIGA)
				|| biome.is(Tags.Biomes.IS_SWAMP)
				|| biome.is(Tags.Biomes.IS_JUNGLE)
				|| biome.is(Tags.Biomes.IS_SAVANNA);
	}

	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.PLANTS_MASTER)) return false;
		return isInValidBiome(player);
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity victim = event.getEntity();
		DamageSource source = event.getSource();

		if (source.getEntity() instanceof Player attacker) {
			if (isActive(attacker)) {
				event.setNewDamage(event.getOriginalDamage() * 1.05f);
			}
		}

		if (victim instanceof Player player && isActive(player)) {
			LivingEntity attacker = source.getDirectEntity() instanceof LivingEntity
					? (LivingEntity) source.getDirectEntity()
					: null;

			if (attacker != null && attacker != player) {
				if (player.getRandom().nextFloat() < 0.25f) {
					float reflected = event.getOriginalDamage() * 0.5f;
					attacker.hurt(player.damageSources().thorns(player), reflected);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (!isActive(player)) return;

		if (player.getFoodData().getSaturationLevel() > 0.0F || player.getFoodData().getFoodLevel() >= 9) {
			if (player.level().getGameTime() % 20 == 0) {
				if (player.getRandom().nextFloat() < 0.1f) {
					player.heal(1.0f);
				}
			}
		}
	}
}