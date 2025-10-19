package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Random;

@EventBusSubscriber
public class IcePassiveSkills {

    private static final Random RANDOM = new Random();
    private static final float COLD_BIOME_THRESHOLD = 0.15f; // Порог "холодного" биома

    private static boolean isInColdBiome(Player player) {
        Level level = player.level();
        if (level.isClientSide()) return false;

        Biome biome = level.getBiome(player.blockPosition()).value();
        return biome.getBaseTemperature() <= COLD_BIOME_THRESHOLD;
    }

    private static boolean hasIceMasterEffect(Player player) {
        return player.hasEffect(PowerModMobEffects.ICE_MASTER); // ← замените на ваш эффект
    }

    @SubscribeEvent
    public static void onLivingAttack(LivingDamageEvent.Pre event) {
        if (event.getSource().getEntity() instanceof Player attacker) {
            if (!attacker.level().isClientSide() && hasIceMasterEffect(attacker) && isInColdBiome(attacker)) {
                LivingEntity target = event.getEntity();

                if (RANDOM.nextFloat() < 0.20f) {
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2));
                    event.setNewDamage(event.getOriginalDamage() * 1.5f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide() || !hasIceMasterEffect(player) || !isInColdBiome(player)) {
            return;
        }

        Level level = player.level();
        BlockPos feetPos = player.blockPosition().below();
        BlockState state = level.getBlockState(feetPos);

        if (state.is(Blocks.WATER)) {
            int waterLevel = state.getValue(BlockStateProperties.LEVEL);
            // Уровень 0 = source block
            if (waterLevel == 0 && level instanceof ServerLevel serverLevel) {
                serverLevel.setBlock(feetPos, Blocks.FROSTED_ICE.defaultBlockState(), 3);
            }
        }
    }
}