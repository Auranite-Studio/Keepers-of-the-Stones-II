package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.Random;

@EventBusSubscriber
public class LightningPassiveSkills {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof Player sourcePlayer
                && sourcePlayer.hasEffect(PowerModMobEffects.LIGHTNING_MASTER)
                && target.level() instanceof ServerLevel serverLevel) {

            if (RANDOM.nextFloat() < 0.1f) {
                LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (lightning != null) {
                    lightning.moveTo(target.getX(), target.getY(), target.getZ());
                    lightning.setCause((ServerPlayer) sourcePlayer);
                    serverLevel.addFreshEntity(lightning);
                }
            }
        }

        if (target instanceof ServerPlayer player
                && player.hasEffect(PowerModMobEffects.LIGHTNING_MASTER)
                && event.getSource().is(DamageTypes.LIGHTNING_BOLT)) {

            if (player.level().isThundering() && player.level().canSeeSky(player.blockPosition().above())) {
                int duration = 200;
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, 1, false, false, true));
                player.addEffect(new MobEffectInstance(PowerModMobEffects.STAR_REGENERATION, duration, 1, false, false, true));
            }
        }
    }
}