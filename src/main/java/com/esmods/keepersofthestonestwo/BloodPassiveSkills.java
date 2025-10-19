package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber
public class BloodPassiveSkills {

	private static final int WITHER_DURATION = 5 * 20;

	private static boolean isBloodMasterActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.BLOOD_MASTER)) return false;

		float health = player.getHealth();
		float maxHealth = player.getMaxHealth();
		return health < maxHealth * 0.5f;
	}

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (target.level().isClientSide()) return;

		if (!isBloodMasterActive(attacker)) return;

		event.setNewDamage(event.getOriginalDamage() * 1.2f);

		if (attacker.getRandom().nextFloat() < 0.1f) {
			target.addEffect(new MobEffectInstance(MobEffects.WITHER, WITHER_DURATION, 1, false, true));
		}
	}

	@SubscribeEvent
	public static void onLivingDeath(LivingDeathEvent event) {
		LivingEntity killed = event.getEntity();
		if (killed.level().isClientSide()) return;

		var source = event.getSource().getEntity();
		if (!(source instanceof Player killer)) return;

		if (!isBloodMasterActive(killer)) return;

		if (killer.getRandom().nextFloat() < 0.5f) {
			float maxHealth = killer.getMaxHealth();
			float healAmount = maxHealth * 0.1f;
			if (healAmount > 0) {
				killer.heal(healAmount);
			}
		}
	}
}