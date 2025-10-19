package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class MercuryPassiveSkills {

    // Проверка: активен ли MercuryMaster
    private static boolean isActive(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.MERCURY_MASTER);
    }

    // Получить температуру биома
    private static float getBiomeTemperature(Player player) {
        Biome biome = player.level().getBiome(player.blockPosition()).value();
        return biome.getModifiedClimateSettings().temperature();
    }

    // Холодный биом: температура < 0.2
    private static boolean isInColdBiome(Player player) {
        return getBiomeTemperature(player) < 0.2f;
    }

    // Тёплый биом: температура > 1.0
    private static boolean isInWarmBiome(Player player) {
        return getBiomeTemperature(player) > 1.0f;
    }

    // === Основной пассив: Ртуть — состояние Твёрдь (холод → +25% урона) ===
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!isActive(attacker)) return;
        if (!isInColdBiome(attacker)) return;

        event.setNewDamage(event.getOriginalDamage() * 1.25f);
    }

    // === Дополнительный пассив: Ртуть — состояние Жидкость (тепло → -50% урона) ===
    @SubscribeEvent
    public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!isActive(player)) return;
        if (!isInWarmBiome(player)) return;

        event.setNewDamage(event.getOriginalDamage() * 0.5f);
    }
}