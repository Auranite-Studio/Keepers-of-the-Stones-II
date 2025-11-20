package com.esmods.keepersofthestonestwo;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class AnimalsPassiveSkills {

	private static boolean hasTamedMobNearby(Player player) {
		return !player.level().getEntitiesOfClass(
				TamableAnimal.class,
				player.getBoundingBox().inflate(16.0, 16.0, 16.0),
				entity -> entity.isTame() && entity.getOwner() == player
		).isEmpty();
	}

	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		DamageSource source = event.getSource();
		Entity attacker = source.getDirectEntity();

		if (attacker instanceof Player player) {
			if (hasTamedMobNearby(player)) {
				event.setNewDamage(event.getOriginalDamage() * 1.2f);
			}
		} else if (attacker instanceof TamableAnimal tameable) {
			if (tameable.isTame() && tameable.getOwner() instanceof Player owner) {
				if (hasTamedMobNearby(owner)) {
					event.setNewDamage(event.getOriginalDamage() * 1.9f);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity entity = event.getEntity();
		if (entity instanceof Player player) {
			if (hasTamedMobNearby(player)) {
				event.setNewDamage(event.getNewDamage() * 0.75f);
			}
		}
	}
}