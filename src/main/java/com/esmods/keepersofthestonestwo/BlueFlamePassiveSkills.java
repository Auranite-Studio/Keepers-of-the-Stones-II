package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class BlueFlamePassiveSkills {

    private static final int FIRE_DURATION = 5 * 20;
    private static final long COMBO_RESET_TIME = 3 * 20;
    private static final int SEARCH_RADIUS = 16;
    private static final int MIN_FIRE_SOURCES = 3;

    private static final Map<UUID, Integer> attackStreak = new HashMap<>();
    private static final Map<UUID, Long> lastAttackTime = new HashMap<>();

    private static boolean isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.BLUE_FLAME_MASTER)) return false;

        Level level = player.level();

        // Условие 1: игрок в Nether
        if (level.dimension() == Level.NETHER) {
            return true;
        }

        // Условие 2: ≥3 источника огня в радиусе 16 блоков
        BlockPos center = player.blockPosition();
        int fireCount = 0;

        for (int x = -SEARCH_RADIUS; x <= SEARCH_RADIUS; x++) {
            for (int y = -SEARCH_RADIUS; y <= SEARCH_RADIUS; y++) {
                for (int z = -SEARCH_RADIUS; z <= SEARCH_RADIUS; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    if (level.getBlockState(pos).is(Blocks.FIRE)) {
                        fireCount++;
                        if (fireCount >= MIN_FIRE_SOURCES) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // === Основной пассив: Языки синего пламени ===
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity target)) return;
        if (!isActive(attacker)) return;

        UUID playerId = attacker.getUUID();
        long currentTime = attacker.level().getGameTime();
        long lastTime = lastAttackTime.getOrDefault(playerId, -100L);
        int streak = attackStreak.getOrDefault(playerId, 0);

        // Обновляем серию атак
        if (currentTime - lastTime <= COMBO_RESET_TIME) {
            streak++;
        } else {
            streak = 1;
        }

        lastAttackTime.put(playerId, currentTime);
        attackStreak.put(playerId, streak);

        // Каждая 3-я атака — поджигает цель
        if (streak % 3 == 0) {
            target.igniteForSeconds(FIRE_DURATION / 20); // setSecondsOnFire принимает секунды
        }
    }

    // === Дополнительный пассив: Иммунитет к огню/лаве/магме ===
    @SubscribeEvent
    public static void onPlayerTakeFireDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!isActive(player)) return;

        var source = event.getSource();

        // Блокируем урон от лавы, огня и магмы
        if (source.is(DamageTypes.IN_FIRE) ||      // горение
            source.is(DamageTypes.ON_FIRE) ||      // поджог
            source.is(DamageTypes.LAVA) ||         // лава
            source.is(DamageTypes.HOT_FLOOR)) {    // магма / обсидиан с магмой
            event.setCanceled(true);
        }
    }
}