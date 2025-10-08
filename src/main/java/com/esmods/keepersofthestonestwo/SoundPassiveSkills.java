package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@EventBusSubscriber
public class SoundPassiveSkills {

    private static final Map<Player, Long> lastStunTime = new HashMap<>();
    private static final Random RANDOM = new Random();

    // Проверка наличия эффекта SoundMaster
    private static boolean hasSoundMaster(Player player) {
        return player.hasEffect(PowerModMobEffects.SOUND_MASTER);
    }

    // Проверка "замкнутого пространства" — объём ≤10 блоков? Упрощённо: радиус 3, объём воздуха ≤ 50%
    private static boolean isInEnclosedSpace(Player player) {
        if (!(player.level() instanceof net.minecraft.server.level.ServerLevel)) return false;

        BlockPos center = player.blockPosition();
        int radius = 4;
        int totalBlocks = 0;
        int airBlocks = 0;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = player.level().getBlockState(pos);
                    totalBlocks++;
                    if (state.isAir() || state.getBlock() == Blocks.CAVE_AIR || state.getBlock() == Blocks.VOID_AIR) {
                        airBlocks++;
                    }
                }
            }
        }

        // Если воздуха ≤ 50% — считаем замкнутым
        return totalBlocks > 0 && (double) airBlocks / totalBlocks <= 0.5;
    }

    // Проверка, атакует ли игрок сзади
    private static boolean isAttackingFromBehind(LivingEntity attacker, LivingEntity target) {
        if (!(attacker instanceof Player) || !(target instanceof Player)) return false;

        double dx = target.getX() - attacker.getX();
        double dz = target.getZ() - attacker.getZ();
        double angleToTarget = Math.toDegrees(Math.atan2(dz, dx)) - 90;
        double attackerYaw = attacker.getYRot();
        double diff = Math.abs((attackerYaw - angleToTarget + 180) % 360 - 180);
        return diff > 90;
    }


    @SubscribeEvent
    public static void onLivingAttack(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        LivingEntity target = event.getEntity();

        if (!(attacker instanceof Player player) || !hasSoundMaster(player)) return;
        if (!isInEnclosedSpace(player)) return;

        long currentTime = System.currentTimeMillis();
        Long lastTime = lastStunTime.getOrDefault(player, 0L);
        if (currentTime - lastTime >= 20_000 && RANDOM.nextFloat() < 0.15f) {
            target.addEffect(new MobEffectInstance(PowerModMobEffects.STUN, 100));
            lastStunTime.put(player, currentTime);
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();

        if (!(target instanceof ServerPlayer player) || !(attacker instanceof LivingEntity)) return;
        if (!hasSoundMaster(player)) return;
        if (!isInEnclosedSpace(player)) return;

        if (isAttackingFromBehind(attacker, player) && RANDOM.nextFloat() < 0.f) {
            if (event instanceof ICancellableEvent _cancellable) {
                    _cancellable.setCanceled(true);
                }
        }
    }
}