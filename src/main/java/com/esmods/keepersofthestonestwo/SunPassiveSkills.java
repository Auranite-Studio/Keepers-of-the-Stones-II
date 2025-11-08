package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class SunPassiveSkills {

    private static final Map<UUID, Long> lastHealTime = new HashMap<>();

    private static boolean canSunMasterApply(ServerPlayer player) {
        if (!player.hasEffect(PowerModMobEffects.SUN_MASTER)) return false;
        if (!player.level().canSeeSky(player.blockPosition())) return false;
        long time = player.level().getDayTime() % 24000;
        return time >= 0 && time < 13000;
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity().level().isClientSide()) return;

        var source = event.getSource().getEntity();
        var target = event.getEntity();

        if (!(source instanceof ServerPlayer attacker)) return;
        if (!(target instanceof LivingEntity)) return;

        if (!canSunMasterApply(attacker)) return;

        if (attacker.level().random.nextFloat() < 0.10f) {
            target.igniteForSeconds(3);
        }

        float health = attacker.getHealth();
        float maxHealth = attacker.getMaxHealth();
        if (health < maxHealth * 0.75f) {
            float original = event.getOriginalDamage();
            event.setNewDamage(original * 1.2f); // ← это работает в .Pre!
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!canSunMasterApply(player)) return;

        float health = player.getHealth();
        float maxHealth = player.getMaxHealth();
        if (health >= maxHealth * 0.75f) return;

        var foodData = player.getFoodData();
        if (foodData.getFoodLevel() < 18 || foodData.getSaturationLevel() <= 0) {
            return;
        }

        long currentTime = player.level().getGameTime();
        UUID uuid = player.getUUID();
        long lastTime = lastHealTime.getOrDefault(uuid, -100L);

        if (currentTime - lastTime >= 8) {
            player.heal(1.0f);
            lastHealTime.put(uuid, currentTime);
            foodData.setSaturation(Math.max(0.0f, foodData.getSaturationLevel() - 6.0f));
        }
    }
}