package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class GoldenDustPassiveSkills {

	private static final int EFFECT_DURATION = 10 * 20; // 10 секунд
	private static final int SEARCH_RADIUS = 16;

	// Проверка: есть ли рядом мастер стихии (element_name_first != 0)
	private static boolean isElementalMasterNearby(Player player) {
		var players = player.level().getEntitiesOfClass(
				Player.class,
				player.getBoundingBox().inflate(SEARCH_RADIUS)
		);

		for (Player other : players) {
			if (other == player) continue;
			String element = other.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first;
			if (!element.equals("0")) {
				return true;
			}
		}
		return false;
	}

	// Проверка: активен ли GoldenDustMaster
	private static boolean isActive(Player player) {
		return !player.level().isClientSide() &&
				player.hasEffect(PowerModMobEffects.GOLDEN_DUST_MASTER) &&
				isElementalMasterNearby(player);
	}

	// === Основной пассив: Золотое усиление (урон и защита) ===
	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		if (target.level().isClientSide()) return;

		// --- Игрок ПОЛУЧАЕТ урон ---
		if (target instanceof Player player) {
			if (isActive(player)) {
				// Снижение урона на 45%
				event.setNewDamage(event.getOriginalDamage() * 0.55f);

				// Золотой шанс: 30% шанс на бафф
				if (player.getRandom().nextFloat() < 0.3f) {
					Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
							MobEffects.REGENERATION,
							PowerModMobEffects.STAR_REGENERATION,
							MobEffects.DAMAGE_BOOST,
							PowerModMobEffects.DASH
					};
					Holder<MobEffect> chosen = effects[player.getRandom().nextInt(effects.length)];

					int amplifier = 1;
					player.addEffect(new MobEffectInstance(chosen, EFFECT_DURATION, amplifier, false, true));
				}
			}
		}

		// --- Игрок НАНОСИТ урон ---
		if (event.getSource().getEntity() instanceof Player attacker) {
			if (isActive(attacker)) {
				// Увеличение урона на 35%
				event.setNewDamage(event.getOriginalDamage() * 1.35f);
			}
		}
	}
}