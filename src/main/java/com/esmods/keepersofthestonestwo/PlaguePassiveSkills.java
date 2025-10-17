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
public class PlaguePassiveSkills {

	private static final int REGEN_DURATION = 5 * 20; // 5 секунд
	private static final int SEARCH_RADIUS = 16;

	// Проверка: активен ли PlagueMaster и рядом есть заражённый
	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.PLAGUE_MASTER)) return false;

		// Ищем любого LivingEntity с эффектом "Чума" в радиусе 16 блоков
		var entities = player.level().getEntitiesOfClass(
				LivingEntity.class,
				player.getBoundingBox().inflate(SEARCH_RADIUS)
		);

		for (LivingEntity entity : entities) {
			if (entity.hasEffect(PowerModMobEffects.PLAGUE)) {
				return true;
			}
		}
		return false;
	}

	// === Основной пассив: Музыкальный ритм ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!isActive(attacker)) return;

		// +20% урона
		event.setNewDamage(event.getOriginalDamage() * 1.2f);

		// 10% шанс получить Регенерацию на 5 сек
		if (attacker.getRandom().nextFloat() < 0.1f) {
			attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, REGEN_DURATION, 0, false, false));
		}
	}

	// === Дополнительный пассив: Чумной доктор (иммунитет к Чуме) ===
	@SubscribeEvent
	public static void onPlagueApplicable(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!player.hasEffect(PowerModMobEffects.PLAGUE_MASTER)) return;

			player.removeEffect(MobEffects.POISON);
	}
}