package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class DestructionPassiveSkills {

    private static final int SEARCH_RADIUS = 16;

    private static boolean hasDestructionMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.DESTRUCTION_MASTER);
    }

    private static boolean isNearElementalBlock(Player player) {
        BlockPos center = player.blockPosition();
        int r = SEARCH_RADIUS;

        for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
                for (int z = -r; z <= r; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    var state = player.level().getBlockState(pos);
                    if (state.is(Blocks.LAVA) || state.is(Blocks.WATER) || state.is(Blocks.FIRE)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isInMountains(Player player) {
        return player.level().getBiome(player.blockPosition()).is(BiomeTags.IS_MOUNTAIN);
    }

    private static boolean isInCave(Player player) {
        BlockPos pos = player.blockPosition();
        return !player.level().canSeeSky(pos.above()) && pos.getY() < 64;
    }

    private static boolean areConditionsMet(Player player) {
        return isNearElementalBlock(player) || isInMountains(player) || isInCave(player);
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (target.level().isClientSide()) return;

        if (!hasDestructionMaster(attacker) || !areConditionsMet(attacker)) return;

        float originalDamage = event.getOriginalDamage();
        event.setNewDamage(originalDamage * 1.4f);

        if (attacker.getRandom().nextFloat() < 0.1f) { // 10%
            float maxHealth = target.getMaxHealth();
            float currentHealth = target.getHealth();

            if (maxHealth > 0 && currentHealth <= maxHealth * 0.25f) {
                event.setNewDamage(currentHealth + 1.0f);
            }
        }
    }
}