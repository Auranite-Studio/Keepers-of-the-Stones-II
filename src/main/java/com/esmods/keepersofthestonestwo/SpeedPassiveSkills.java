package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class SpeedPassiveSkills {

	private static final int DASH_DURATION = 3 * 20; // 3 секунды в тиках

	private static boolean isActive(Player player) {
		return !player.level().isClientSide() &&
				player.hasEffect(PowerModMobEffects.SPEED_MASTER) &&
				player.isSprinting();
	}

	// === Оба пассива обрабатываются при атаке игрока ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity)) return;

		if (!isActive(attacker)) return;

		event.setNewDamage(event.getOriginalDamage() * 1.25f);

		if (attacker.getRandom().nextFloat() < 0.15f) {
			attacker.addEffect(new MobEffectInstance(
					PowerModMobEffects.DASH,
					DASH_DURATION,
					0,
					false,
					false
			));
		}
	}
}