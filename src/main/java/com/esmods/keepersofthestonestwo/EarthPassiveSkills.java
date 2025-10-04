package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.Random;

@EventBusSubscriber
public class EarthPassiveSkills {

	private static final Random RANDOM = new Random();

	@SubscribeEvent
	public static void onIncomingDamage(LivingIncomingDamageEvent event) {
		LivingEntity entity = event.getEntity();

		if (!(entity instanceof Player player)) return;
		if (player.level().isClientSide()) return;
		if (!player.hasEffect(PowerModMobEffects.EARTH_MASTER)) return;
		if (player.getBlockY() >= 96) return;

		DamageSource source = event.getSource();
		if (source.getEntity() instanceof LivingEntity) {
			float originalDamage = event.getOriginalAmount();
			float reducedDamage = originalDamage * 0.8f;
			event.setAmount(reducedDamage);
		}
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		DamageSource source = target.getLastDamageSource();

		if (source == null) return;

		if (!(source.getEntity() instanceof Player player)) return;
		if (player.level().isClientSide()) return;
		if (!player.hasEffect(PowerModMobEffects.EARTH_MASTER)) return;
		if (player.getBlockY() >= 96) return;

		if (RANDOM.nextFloat() < 0.25f) {
			float originalDamage = event.getOriginalDamage();
			float critDamage = originalDamage * 2.0f;
			event.setNewDamage(critDamage);
		}
	}
}