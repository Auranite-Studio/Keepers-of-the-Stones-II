package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class TimePassiveSkills {

	private static final Map<UUID, UUID> countdownOwner = new HashMap<>();
	private static final int COUNTDOWN_DURATION = 3 * 20;
	private static final int DASH_DURATION = 5 * 20;

	private static boolean isTimeMasterActive(Player player) {
		if (player.level().isClientSide()) return false;
		var effect = player.getEffect(PowerModMobEffects.TIME_MASTER);
		if (effect == null) return false;

		int duration = effect.getDuration();
		int amplifier = effect.getAmplifier();

		var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
		final double TIME_MASTER_MAX_DURATION = playerVars.master_effect_duration * 20;

		return duration <= TIME_MASTER_MAX_DURATION / 2;
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (target.level().isClientSide()) return;

		if (!isTimeMasterActive(attacker)) return;

		float originalDamage = event.getOriginalDamage();

		event.setNewDamage(originalDamage * 1.5f);

		if (attacker.getRandom().nextFloat() < 0.2f) {
			attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, DASH_DURATION, 2, false, false));
		}

		if (attacker.getRandom().nextFloat() < 0.25f) {
			target.addEffect(new MobEffectInstance(PowerModMobEffects.COUNTDOWN, COUNTDOWN_DURATION, 0, false, true));
			countdownOwner.put(target.getUUID(), attacker.getUUID());
		}
	}

	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		LivingEntity target = event.getEntity();
		if (target.level().isClientSide()) return;

		if (!target.hasEffect(PowerModMobEffects.COUNTDOWN)) return;

		UUID attackerId = countdownOwner.remove(target.getUUID());
		if (attackerId == null) return;

		if (target.level() instanceof net.minecraft.server.level.ServerLevel serverLevel) {
			var attacker = serverLevel.getPlayerByUUID(attackerId);
			if (attacker instanceof ServerPlayer serverPlayer && !serverPlayer.isDeadOrDying()) {
				float maxHealth = target.getMaxHealth();
				if (maxHealth > 0) {
					serverPlayer.heal(maxHealth);
				}
			}
		}
	}
}