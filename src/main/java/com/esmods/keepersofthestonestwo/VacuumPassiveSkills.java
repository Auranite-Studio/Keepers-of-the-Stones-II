package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class VacuumPassiveSkills {

    private static final Map<UUID, Long> lastImmortalityTrigger = new HashMap<>();

    @SubscribeEvent
    public static void onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();
        DamageSource source = event.getSource();

        if (!(entity instanceof Player player) || level.isClientSide()) {
            return;
        }

        if (!player.hasEffect(PowerModMobEffects.VACUUM_MASTER)) {
            return;
        }

        if (source.getEntity() == null || !(source.getEntity() instanceof LivingEntity)) {
            return;
        }

        float originalDamage = event.getOriginalDamage();
        float reducedDamage = originalDamage * 0.5f;
        event.setNewDamage(reducedDamage);

        if (player instanceof ServerPlayer serverPlayer) {
            long currentTime = level.getGameTime();

            if (lastImmortalityTrigger.containsKey(serverPlayer.getUUID())) {
                long lastTime = lastImmortalityTrigger.get(serverPlayer.getUUID());
                if (currentTime - lastTime < 3600) {
                    return;
                }
            }

            if (level.random.nextFloat() < 0.15f) {
                serverPlayer.addEffect(new MobEffectInstance(PowerModMobEffects.IMMORTALITY, 400, 0, false, true, true));
                lastImmortalityTrigger.put(serverPlayer.getUUID(), currentTime);
            }
        }
    }
}