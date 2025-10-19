package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.Random;

@EventBusSubscriber
public class TornadoPassiveSkills {

	private static final Random RANDOM = new Random();

	// Настройки пассива "Вихревой поток"
	private static final float DASH_ACTIVATION_CHANCE = 0.3f;
	private static final int DASH_DURATION_TICKS = 10 * 20;
	private static final int DASH_COOLDOWN_TICKS = 40 * 20;

	// Ключи для сохранения данных
	private static final String PERSISTENT_DATA_KEY = "power";
	private static final String LAST_ACTIVATION_TICK_KEY = "tornado_last_activation";

	@SubscribeEvent
	public static void onLivingDamage(LivingDamageEvent.Pre event) {
		Level level = event.getEntity().level();
		if (!(level instanceof ServerLevel serverLevel)) return;

		LivingEntity target = event.getEntity();
		ServerPlayer attacker = null;

		// Определяем атакующего игрока
		if (event.getSource().getEntity() instanceof ServerPlayer sp) {
			attacker = sp;
		} else if (event.getSource().getDirectEntity() instanceof ServerPlayer sp) {
			attacker = sp;
		}

		if (attacker == null) return;
		if (!attacker.hasEffect(PowerModMobEffects.TORNADO_MASTER)) return;
		if (!isPlayerInOpenArea(attacker)) return;

		// === Основной пассив: подброс (15%) ===
		if (RANDOM.nextFloat() < 0.15f) {
			target.setDeltaMovement(target.getDeltaMovement().x(), 0.8, target.getDeltaMovement().z());
			target.hurtMarked = true;
		}

		// === Дополнительный пассив: Вихревой поток (30%, кулдаун 40 сек) ===
		if (RANDOM.nextFloat() < DASH_ACTIVATION_CHANCE) {
			CompoundTag persistentData = attacker.getPersistentData();
			CompoundTag modData = persistentData.getCompound(PERSISTENT_DATA_KEY);
			int currentTick = (int) attacker.level().getGameTime();
			int lastActivationTick = modData.getInt(LAST_ACTIVATION_TICK_KEY);

			if (lastActivationTick + DASH_COOLDOWN_TICKS <= currentTick) {
				// Применяем эффект Рывка (DASH)
				attacker.addEffect(new MobEffectInstance(
						PowerModMobEffects.DASH,
						DASH_DURATION_TICKS,
						1,
						false,
						true,
						true
				));

				// Сохраняем время активации
				modData.putInt(LAST_ACTIVATION_TICK_KEY, currentTick);
				persistentData.put(PERSISTENT_DATA_KEY, modData);
			}
		}
	}

	private static boolean isPlayerInOpenArea(ServerPlayer player) {
		return player.level().canSeeSky(player.blockPosition().above());
	}
}