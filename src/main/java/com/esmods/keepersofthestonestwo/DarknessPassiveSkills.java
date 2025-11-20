package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class DarknessPassiveSkills {

    private static final int EFFECT_DURATION = 10 * 20; // 10 секунд

    // Проверка: ночь или низкий уровень света
    private static boolean isInDarkness(Player player) {
        Level level = player.level();

        // Условие 1: уровень освещения < 7 (в любом измерении)
        if (level.getMaxLocalRawBrightness(player.blockPosition()) <= 7) {
            return true;
        }

        // Условие 2: ночь в Overworld
        if (level.dimension() == Level.OVERWORLD) {
            long time = level.getDayTime() % 24000;
            return time >= 13000 && time < 23000; // ночь
        }

        return false;
    }

    // Проверка: активен ли DarkMaster и условия тьмы соблюдены
    private static boolean isActive(Player player) {
        return !player.level().isClientSide() &&
               player.hasEffect(PowerModMobEffects.DARKNESS_MASTER) &&
               isInDarkness(player);
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (target.level().isClientSide()) return;

        // === Игрок ПОЛУЧАЕТ урон (Покрывало тьмы: -45%) ===
        if (target instanceof Player player) {
            if (isActive(player)) {
                event.setNewDamage(event.getOriginalDamage() * 0.55f); // 100% - 45% = 55%
            }
        }

        // === Игрок НАНОСИТ урон (Покрывало тьмы: +35% + Тёмный плащ) ===
        if (event.getSource().getEntity() instanceof Player attacker) {
            if (isActive(attacker)) {
                // +35% урона
                event.setNewDamage(event.getOriginalDamage() * 1.35f);

                // 30% шанс наложить случайный дебафф
                if (attacker.getRandom().nextFloat() < 0.3f) {
                    Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
                            MobEffects.WEAKNESS,
                            MobEffects.MOVEMENT_SLOWDOWN,
                            PowerModMobEffects.STUN,
                            MobEffects.BLINDNESS
                    };
                    Holder<MobEffect> chosen = effects[attacker.getRandom().nextInt(effects.length)];

                    int amplifier = 1; // II уровень для первых двух

                    // Для Слепоты и Оглушения — уровень I (amplifier = 0)
                    if (chosen == MobEffects.BLINDNESS || chosen == PowerModMobEffects.STUN.get()) {
                        amplifier = 0;
                    }

                    if (target instanceof LivingEntity livingTarget) {
                        livingTarget.addEffect(new MobEffectInstance(chosen, EFFECT_DURATION, amplifier, false, true));
                    }
                }
            }
        }
    }
}