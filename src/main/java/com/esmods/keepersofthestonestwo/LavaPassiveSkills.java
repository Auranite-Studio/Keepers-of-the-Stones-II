package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.Random;

@EventBusSubscriber
public class LavaPassiveSkills {

    private static final Random RANDOM = new Random();
    private static final int LAVA_CHECK_RADIUS = 5;

    private static boolean isLavaMasterConditionMet(Player player) {
        if (player.level().dimension().location().getPath().equals("the_nether")) {
            return true;
        }

        BlockPos playerPos = player.blockPosition();
        for (int x = -LAVA_CHECK_RADIUS; x <= LAVA_CHECK_RADIUS; x++) {
            for (int y = -LAVA_CHECK_RADIUS; y <= LAVA_CHECK_RADIUS; y++) {
                for (int z = -LAVA_CHECK_RADIUS; z <= LAVA_CHECK_RADIUS; z++) {
                    BlockPos checkPos = playerPos.offset(x, y, z);
                    BlockState state = player.level().getBlockState(checkPos);

                    if (state.is(Blocks.LAVA) || state.is(Blocks.MAGMA_BLOCK)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void onIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();

        if (!(entity instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.LAVA_MASTER)) return;
        if (!isLavaMasterConditionMet(player)) return;

        DamageSource source = event.getSource();
        if (source.is(DamageTypes.LAVA) || source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE)) {
            event.setCanceled(true); //
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();

        if (!(attacker instanceof Player player)) return;
        if (player.level().isClientSide()) return;
        if (!player.hasEffect(PowerModMobEffects.LAVA_MASTER)) return;
        if (!isLavaMasterConditionMet(player)) return;

        if (RANDOM.nextFloat() < 0.125f) {
            float originalDamage = event.getOriginalDamage();
            float critDamage = originalDamage * 1.5f;
            event.setNewDamage(critDamage);
        }
    }
}