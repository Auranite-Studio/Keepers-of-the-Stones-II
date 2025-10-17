package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@EventBusSubscriber
public class PoisonPassiveSkills {

	private static final int POISON_DURATION = 5 * 20; // 5 сек
	private static final int IMMUNITY_COOLDOWN = 30 * 20; // 30 сек

	private static final Map<UUID, Long> lastImmunityTime = new HashMap<>();

	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.POISON_MASTER)) return false;
		return hasPoisonPotion(player);
	}

	private static boolean hasPoisonPotion(Player player) {
		for (var stack : player.getInventory().items) {
			if (!stack.isEmpty() && stack.is(Items.POTION)) {
				PotionContents contents = stack.get(DataComponents.POTION_CONTENTS);
				if (contents != null) {
					Optional<Holder<Potion>> potionOpt = contents.potion();
					if (potionOpt.isPresent() && potionOpt.get() == Potions.POISON) {
						return true;
					}
				}
			}
		}
		var offhand = player.getOffhandItem();
		if (!offhand.isEmpty() && offhand.is(Items.POTION)) {
			PotionContents contents = offhand.get(DataComponents.POTION_CONTENTS);
			if (contents != null) {
				Optional<Holder<Potion>> potionOpt = contents.potion();
				return potionOpt.isPresent() && potionOpt.get() == Potions.POISON;
			}
		}
		return false;
	}

	// === Ядовитая стрела ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity target)) return;
		if (!isActive(attacker)) return;

		event.setNewDamage(event.getOriginalDamage() * 1.25f);

		if (attacker.getRandom().nextFloat() < 0.25f) {
			target.addEffect(new MobEffectInstance(MobEffects.POISON, POISON_DURATION, 1, false, true));
		}
	}

	@SubscribeEvent
	public static void onPoisonApplicable(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!isActive(player)) return;
		player.removeEffect(MobEffects.POISON);
	}

	@SubscribeEvent
	public static void onDebuffAdded(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!isActive(player)) return;

		UUID playerId = player.getUUID();
		long currentTime = player.level().getGameTime();

		Long lastTime = lastImmunityTime.get(playerId);
		if (lastTime == null || (currentTime - lastTime) >= IMMUNITY_COOLDOWN) {
			if (player.getRandom().nextFloat() < 0.25f) {
				for (int index0 = 0; index0 < 20; index0++) {
					for (MobEffectInstance effectInstance : player.getActiveEffects()) {
						if (effectInstance.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
							player.removeEffect(effectInstance.getEffect());
							break;
						}
					}
				}
				lastImmunityTime.put(playerId, currentTime);
			}
		}
	}
}