package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class FormPassiveSkills {

    // Проверка: активен ли FormMaster
    private static boolean hasFormMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.FORM_MASTER);
    }

    // === Дополнительный пассив: Увеличение (гигантизация → +50% урона) ===
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!hasFormMaster(attacker)) return;

        if (attacker.hasEffect(PowerModMobEffects.GIGANTIZATION)) {
            event.setNewDamage(event.getOriginalDamage() * 1.5f); // +50%
        }
    }

    // === Основной пассив: Уменьшение (миниатюризация → -75% урона) ===
    @SubscribeEvent
    public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!hasFormMaster(player)) return;

        // Проверяем: есть ли эффект миниатюризации
        if (player.hasEffect(PowerModMobEffects.MINIATURIZATION)) {
            event.setNewDamage(event.getOriginalDamage() * 0.25f); // оставляем 25% → снижение на 75%
        }
    }
}