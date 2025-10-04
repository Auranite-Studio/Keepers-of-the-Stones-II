package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class EtherPassiveSkills {

    private static final String LAST_STAR_REGEN_KEY = "ethermaster_last_star_regen";
    private static final String DAMAGE_BOOST_EXPIRE_TICK = "ethermaster_damage_boost_expire";

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        // Работает ТОЛЬКО при наличии EtherMaster
        if (!player.hasEffect(PowerModMobEffects.ETHER_MASTER)) {
            return;
        }

        var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
        if (playerVars == null) return;

        int prevPower = player.getPersistentData().getInt("prev_power");
        int currentPower = (int) playerVars.power;

        player.getPersistentData().putInt("prev_power", currentPower);

        if (currentPower < prevPower) {
            long currentTime = player.level().getGameTime();

            player.getPersistentData().putLong(DAMAGE_BOOST_EXPIRE_TICK, currentTime + 400);

            long lastStarRegen = player.getPersistentData().getLong(LAST_STAR_REGEN_KEY);
            if (currentTime - lastStarRegen >= 2400) {
                if (player.getRandom().nextFloat() < 0.5f) {
                    player.addEffect(new MobEffectInstance(PowerModMobEffects.STAR_REGENERATION, 400, 1, false, false));
                    player.getPersistentData().putLong(LAST_STAR_REGEN_KEY, currentTime);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingDamageEvent.Pre event) {
        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        if (!(attacker instanceof Player player)) {
            return;
        }

        if (!player.hasEffect(PowerModMobEffects.ETHER_MASTER)) {
            return;
        }

        long currentTime = player.level().getGameTime();
        long expireTick = player.getPersistentData().getLong(DAMAGE_BOOST_EXPIRE_TICK);

        if (currentTime < expireTick) {
            event.setNewDamage(event.getOriginalDamage() * 1.1f);
        }
    }
}