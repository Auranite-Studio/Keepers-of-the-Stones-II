package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber
public class SpiritPassiveSkills {

	private static final int BONUS_DURATION = 8 * 20;
	private static final int CLEARING_DURATION = 60 * 20;

	private static boolean isActive(Player player) {
		return !player.level().isClientSide() &&
				player.hasEffect(PowerModMobEffects.SPIRIT_MASTER) &&
				player.hasEffect(PowerModMobEffects.PURIFICATION);
	}

	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!isActive(attacker)) return;
		event.setNewDamage(event.getOriginalDamage() * 1.2f);
	}

	@SubscribeEvent
	public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!isActive(player)) return;

		if (player.getRandom().nextFloat() < 0.25f) {
			Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
					MobEffects.REGENERATION,
					PowerModMobEffects.STAR_REGENERATION,
					MobEffects.DAMAGE_BOOST
			};
			Holder<MobEffect> chosen = effects[player.getRandom().nextInt(effects.length)];

			player.addEffect(new MobEffectInstance(chosen, BONUS_DURATION, 0, false, true));
		}
	}

	@SubscribeEvent
	public static void onUndeadKill(LivingDeathEvent event) {
		LivingEntity killed = event.getEntity();
		if (killed.level().isClientSide()) return;

		if (!killed.getType().is(EntityTypeTags.UNDEAD)) return;

		var source = event.getSource().getEntity();
		if (!(source instanceof Player player)) return;

		if (player.hasEffect(PowerModMobEffects.SPIRIT_MASTER)) {
			player.addEffect(new MobEffectInstance(
					PowerModMobEffects.PURIFICATION,
					CLEARING_DURATION,
					0,
					false,
					true
			));
		}
	}
}