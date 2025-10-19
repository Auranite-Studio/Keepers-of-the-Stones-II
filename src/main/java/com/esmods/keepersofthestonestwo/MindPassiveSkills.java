package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class MindPassiveSkills {

    private static final int DASH_DURATION = 15 * 20; // 15 сек
    private static final int SEARCH_RADIUS = 16;

    private static boolean hasMindMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.MIND_MASTER);
    }

    private static boolean isHypnotized(Player player) {
        String owner = player.getData(PowerModVariables.PLAYER_VARIABLES).mind_player_owner;
        return owner != null && !owner.isEmpty();
    }

    private static boolean isHypnotizedPlayerNearby(Player player) {
        var players = player.level().getEntitiesOfClass(Player.class, player.getBoundingBox().inflate(SEARCH_RADIUS));
        return players.stream().anyMatch(p -> p != player && isHypnotized(p));
    }

    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;

        if (hasMindMaster(attacker) && isHypnotizedPlayerNearby(attacker)) {
            event.setNewDamage(event.getOriginalDamage() * 1.2f);
        } else if (isHypnotized(attacker)) {
            event.setNewDamage(event.getOriginalDamage() * 1.1f);
        }

        boolean applyDash = false;

        if (hasMindMaster(attacker) && isHypnotizedPlayerNearby(attacker)) {
            if (attacker.getRandom().nextFloat() < 0.15f) {
                applyDash = true;
            }
        }
        else if (isHypnotized(attacker)) {
            String ownerId = attacker.getData(PowerModVariables.PLAYER_VARIABLES).mind_player_owner;
            if (ownerId != null && !ownerId.isEmpty()) {
                try {
                    Player owner = attacker.level().getPlayerByUUID(java.util.UUID.fromString(ownerId));
                    if (owner != null && 
                        hasMindMaster(owner) && 
                        owner.distanceToSqr(attacker) <= SEARCH_RADIUS * SEARCH_RADIUS) {
                        if (attacker.getRandom().nextFloat() < 0.15f) {
                            applyDash = true;
                        }
                    }
                } catch (IllegalArgumentException ignored) {}
            }
        }

        if (applyDash) {
            attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, DASH_DURATION, 0, false, false));
        }
    }
}