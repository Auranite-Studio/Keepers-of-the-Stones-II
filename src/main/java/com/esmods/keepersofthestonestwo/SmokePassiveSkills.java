package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class SmokePassiveSkills {

    private static final int EFFECT_DURATION = 10 * 20; // 10 секунд
    private static final int SEARCH_RADIUS = 16;

    private static boolean isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.SMOKE_MASTER)) return false;

        var level = player.level();
        var center = player.blockPosition();

        for (int x = -SEARCH_RADIUS; x <= SEARCH_RADIUS; x++) {
            for (int y = -SEARCH_RADIUS; y <= SEARCH_RADIUS; y++) {
                for (int z = -SEARCH_RADIUS; z <= SEARCH_RADIUS; z++) {
                    var pos = center.offset(x, y, z);
                    var block = level.getBlockState(pos).getBlock();

                    if (block == Blocks.FIRE ||
                        block == Blocks.CAMPFIRE ||
                        block == Blocks.SOUL_CAMPFIRE) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // === Основной пассив: Фантомный дым ===
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!isActive(attacker)) return;

        // +10% урона
        event.setNewDamage(event.getOriginalDamage() * 1.1f);

        if (attacker.getRandom().nextFloat() < 0.15f) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, EFFECT_DURATION, 1, false, true));
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, EFFECT_DURATION, 0, false, true));
        }
    }

    // === Дополнительный пассив: Плотный дым ===
    @SubscribeEvent
    public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!isActive(player)) return;

        if (player.getRandom().nextFloat() < 0.15f) {
            event.setNewDamage(event.getOriginalDamage() * 0.25f);
        }
    }
}