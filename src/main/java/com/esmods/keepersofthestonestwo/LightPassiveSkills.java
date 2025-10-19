package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@EventBusSubscriber
public class LightPassiveSkills {

    private static final Map<UUID, Long> dashCooldowns = new HashMap<>();

    @SubscribeEvent
    public static void onLivingDamaged(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();

        var source = event.getSource();
        if (source.getEntity() instanceof Player attacker) {
            if (!hasLightMasterAndEnoughLight(attacker)) {
                return;
            }

            float originalDamage = event.getOriginalDamage();
            event.setNewDamage(originalDamage * 1.2f);
            UUID playerId = attacker.getUUID();
            long currentTime = attacker.level().getGameTime();

            if (dashCooldowns.containsKey(playerId)) {
                long lastUsed = dashCooldowns.get(playerId);
                if (currentTime - lastUsed < 25 * 20) {
                    return;
                }
            }

            if (attacker.getRandom().nextFloat() < 0.1f) {
                attacker.addEffect(new MobEffectInstance(PowerModMobEffects.DASH, 7 * 20, 1, false, false));
                dashCooldowns.put(playerId, currentTime);
            }
        }
    }

    private static boolean hasLightMasterAndEnoughLight(Player player) {
        if (!player.hasEffect(PowerModMobEffects.LIGHT_MASTER)) {
            return false;
        }
        int lightLevel = player.level().getMaxLocalRawBrightness(player.blockPosition());
        return lightLevel >= 12;
    }
}