package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class SandPassiveSkills {

    private static final int EFFECT_DURATION = 10 * 20; // 10 сек

    // Проверка активности
    private static boolean isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.SAND_MASTER)) return false;

        var biome = player.level().getBiome(player.blockPosition());
        return biome.is(BiomeTags.HAS_VILLAGE_DESERT) || biome.is(BiomeTags.IS_BADLANDS);
    }

    // === Песчаная буря: случайный эффект при атаке ===
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!isActive(attacker)) return;

        if (attacker.getRandom().nextFloat() < 0.1f) {
            Holder<MobEffect>[] effects = (Holder<MobEffect>[]) new Holder<?>[]{
                    MobEffects.BLINDNESS,
                    MobEffects.MOVEMENT_SLOWDOWN,
                    PowerModMobEffects.STUN
            };
            Holder<MobEffect> chosen = effects[attacker.getRandom().nextInt(effects.length)];

            target.addEffect(new MobEffectInstance(chosen, EFFECT_DURATION, 0, false, true));
        }
    }

    // === Дюна: снижение урона ===
    @SubscribeEvent
    public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!isActive(player)) return;

        var source = event.getSource();
        float original = event.getOriginalDamage();

        if (source.is(DamageTypes.FALL)) {
            event.setNewDamage(original * 0.25f);
        } else if (source.getEntity() instanceof LivingEntity || source.getDirectEntity() instanceof LivingEntity) {
            event.setNewDamage(original * 0.75f);
        }
    }
}