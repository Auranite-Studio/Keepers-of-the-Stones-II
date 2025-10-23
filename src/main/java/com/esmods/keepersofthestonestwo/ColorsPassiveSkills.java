package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class ColorsPassiveSkills {

	private static final int BLINDNESS_DURATION = 7 * 20;

	private static boolean hasDye(Player player) {
		for (var stack : player.getInventory().items) {
			if (!stack.isEmpty() && stack.getItem() instanceof DyeItem) {
				return true;
			}
		}
		var offhand = player.getOffhandItem();
		return !offhand.isEmpty() && offhand.getItem() instanceof DyeItem;
	}

	private static boolean isActive(Player player) {
		return !player.level().isClientSide() &&
				player.hasEffect(PowerModMobEffects.COLORS_MASTER) &&
				hasDye(player);
	}

	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity target)) return;
		if (!isActive(attacker)) return;

		if (attacker.getRandom().nextFloat() < 0.1f) {
			target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, BLINDNESS_DURATION, 0, false, true));
		}
	}

	@SubscribeEvent
	public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!isActive(player)) return;

		event.setNewDamage(event.getOriginalDamage() * 0.75f);
	}
}