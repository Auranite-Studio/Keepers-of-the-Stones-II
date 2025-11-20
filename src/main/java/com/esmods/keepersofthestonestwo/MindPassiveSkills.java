package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.UUID;

@EventBusSubscriber
public class MindPassiveSkills {

    private static final int DASH_DURATION = 15 * 20; // 15 секунд
    private static final int SEARCH_RADIUS = 16;

    private static boolean hasMindMaster(Player player) {
        return !player.level().isClientSide() && player.hasEffect(PowerModMobEffects.MIND_MASTER);
    }

    // Игрок считается гипнотизированным, ТОЛЬКО если владелец существует и онлайн
    private static Player getHypnotizer(Player hypnotized) {
        String ownerIdStr = hypnotized.getData(PowerModVariables.PLAYER_VARIABLES).mind_player_owner;
        if (ownerIdStr == null || ownerIdStr.isEmpty()) {
            return null;
        }
        try {
            UUID ownerId = UUID.fromString(ownerIdStr);
            Player owner = hypnotized.level().getPlayerByUUID(ownerId);
            return owner; // может быть null, если оффлайн
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean isHypnotizedAndControlled(Player player) {
        return getHypnotizer(player) != null;
    }

    // Проверяет, есть ли рядом хотя бы один игрок, который:
    // - гипнотизирован,
    // - и его владелец онлайн
    private static boolean isControlledHypnotizedPlayerNearby(Player mindMaster) {
        return mindMaster.level()
                .getEntitiesOfClass(Player.class, mindMaster.getBoundingBox().inflate(SEARCH_RADIUS))
                .stream()
                .anyMatch(p -> !p.getUUID().equals(mindMaster.getUUID()) && isHypnotizedAndControlled(p));
    }

    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;
        if (attacker.level().isClientSide()) return;

        boolean applyDash = false;

        // Случай 1: атакующий — мастер разума, рядом есть гипнотизированный с живым владельцем
        if (hasMindMaster(attacker) && isControlledHypnotizedPlayerNearby(attacker)) {
            event.setNewDamage(event.getOriginalDamage() * 1.2f);
            if (attacker.getRandom().nextFloat() < 0.15f) {
                applyDash = true;
            }
        }
        // Случай 2: атакующий сам гипнотизирован, и его владелец онлайн и рядом
        else {
            Player hypnotizer = getHypnotizer(attacker);
            if (hypnotizer != null) {
                // Владелец должен быть мастером разума и в радиусе
                if (hasMindMaster(hypnotizer) && hypnotizer.distanceToSqr(attacker) <= SEARCH_RADIUS * SEARCH_RADIUS) {
                    event.setNewDamage(event.getOriginalDamage() * 1.1f);
                    if (attacker.getRandom().nextFloat() < 0.15f) {
                        applyDash = true;
                    }
                }
            }
        }

        if (applyDash) {
            attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, DASH_DURATION, 0, false, false));
        }
    }
}