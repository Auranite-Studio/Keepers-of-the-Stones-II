package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@EventBusSubscriber
public class ShadowPassiveSkills {

    private static final Map<UUID, Long> weaknessCooldowns = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        MobEffectInstance existing = player.getEffect(MobEffects.NIGHT_VISION);

        if (!hasShadowMasterAndLowLight(player)) return;

        if (!player.hasEffect(MobEffects.NIGHT_VISION)) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
        }
        else if (existing.getDuration() < 240) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false));
        }
    }

    @SubscribeEvent
    public static void onLivingDamaged(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        var source = event.getSource();

        if (source.getEntity() instanceof Player attacker) {
            if (!hasShadowMasterAndLowLight(attacker)) return;

            float originalDamage = event.getOriginalDamage();
            event.setNewDamage(originalDamage * 1.2f);

            UUID playerId = attacker.getUUID();
            long currentTime = attacker.level().getGameTime();

            if (weaknessCooldowns.containsKey(playerId)) {
                long lastUsed = weaknessCooldowns.get(playerId);
                if (currentTime - lastUsed < 25 * 20) {
                    return;
                }
            }

            if (attacker.getRandom().nextFloat() < 0.1f) {
                target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 7 * 20, 1, false, true));
                weaknessCooldowns.put(playerId, currentTime);
            }
        }
    }

    private static boolean hasShadowMasterAndLowLight(Player player) {
        if (!player.hasEffect(PowerModMobEffects.SHADOW_MASTER)) {
            return false;
        }

        int lightLevel = player.level().getMaxLocalRawBrightness(player.blockPosition());
        return lightLevel <= 5;
    }
}