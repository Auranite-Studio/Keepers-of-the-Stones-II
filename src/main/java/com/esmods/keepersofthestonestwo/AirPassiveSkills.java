package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.Random;

@EventBusSubscriber
public class AirPassiveSkills {

	private static final Random RANDOM = new Random();

	@SubscribeEvent
	public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
		LivingEntity entity = event.getEntity();

		if (!(entity instanceof Player player)) return;
		if (!event.getSource().is(DamageTypes.FALL)) return;

		boolean hasAirMaster = player.hasEffect(PowerModMobEffects.AIR_MASTER);
		boolean isHighEnough = player.getBlockY() >= 96;

		if (hasAirMaster && isHighEnough) {
			float originalDamage = event.getAmount();
			float reducedDamage = originalDamage * 0.25f;
			event.setAmount(reducedDamage);
		}
	}

	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();

		Entity attacker = event.getSource().getEntity();
		if (!(attacker instanceof Player player)) return;

		if (player.level().isClientSide()) return;

		if (!player.hasEffect(PowerModMobEffects.AIR_MASTER) || player.getBlockY() < 96) {
			return;
		}

		if (target instanceof Player) {
			return;
		}

		if (RANDOM.nextFloat() < 0.15f) {
			double dx = target.getX() - player.getX();
			double dz = target.getZ() - player.getZ();
			double horizontalDist = Math.sqrt(dx * dx + dz * dz);

			if (horizontalDist > 0.01) {
				dx /= horizontalDist;
				dz /= horizontalDist;
			} else {
				dx = RANDOM.nextGaussian();
				dz = RANDOM.nextGaussian();
				double len = Math.sqrt(dx * dx + dz * dz);
				if (len > 0) {
					dx /= len;
					dz /= len;
				}
			}

			target.push(dx * 1.5, 0.35, dz * 1.5);
			target.hurtMarked = true;
		}
	}
}