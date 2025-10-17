package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class GravityPassiveSkills {

	private static final int LEVITATION_DURATION = 25 * 20; // 25 секунд
	private static final int SLOW_FALLING_DURATION = 30;    // 1.5 сек (обновляется каждый тик)

	// Проверка: активен ли GravityMaster и игрок на открытой местности
	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.GRAVITY_MASTER)) return false;
		// Открытая местность = видно небо над головой
		return player.level().canSeeSky(player.blockPosition().above());
	}

	// === Основной пассив: Гравитационная волна ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity target)) return;
		if (!isActive(attacker)) return;

		// 10% шанс наложить Левитацию на 25 сек
		if (attacker.getRandom().nextFloat() < 0.1f) {
			target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, LEVITATION_DURATION, 0, false, true));
		}
	}

	// === Дополнительный пассив: Перья птицы ===
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (player.level().isClientSide()) return;
		if (!isActive(player)) return;

		// Постоянно обновляем эффект "Замедление падения"
		if (!player.hasEffect(MobEffects.SLOW_FALLING)) {
			player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, SLOW_FALLING_DURATION, 0, false, false));
		}
	}
}