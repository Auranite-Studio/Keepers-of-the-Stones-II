package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class MoonPassiveSkills {

    @SubscribeEvent
    public static void onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (!(attacker instanceof Player player)) return;

        if (!player.hasEffect(PowerModMobEffects.MOON_MASTER)) return;

        if (!player.level().isNight()) return;

        if (!player.level().canSeeSky(player.blockPosition())) return;

        int moonPhase = player.level().getMoonPhase();

        if (moonPhase == 0) {
            event.setNewDamage(event.getOriginalDamage() * 1.5f);

            if (player.getRandom().nextFloat() < 0.3f) {
                LivingEntity target = event.getEntity();
                if (target instanceof LivingEntity livingTarget) {
                    livingTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 2, false, true));
                }
            }
        } else {
            event.setNewDamage(event.getOriginalDamage() * 1.1f);

            if (player.getRandom().nextFloat() < 0.10f) {
                var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
                if (playerVars != null) {
                    playerVars.power += 10;
                }
            }
        }
    }
}