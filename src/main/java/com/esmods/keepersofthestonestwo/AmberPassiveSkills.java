package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class AmberPassiveSkills {

    private static final int ACCUMULATION_INTERVAL = 30 * 20; // 30 секунд = 600 тиков
    private static final int STAR_POINTS_AMOUNT = 20;

    // Проверка: активен ли пассив (эффект + скопированный элемент в инвентаре)
    private static boolean isActive(Player player) {
        var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);

        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.AMBER_MASTER)) return false;

        return playerVars.fake_element_name_first != null && playerVars.fake_element_name_first != "0";
    }

    @SubscribeEvent
    public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!isActive(player)) return;

        event.setNewDamage(event.getOriginalDamage() * 0.8f);
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!(player instanceof ServerPlayer)) return;
        if (!isActive(player)) return;

        long gameTime = player.level().getGameTime();
        if (gameTime % ACCUMULATION_INTERVAL == 0) {
            var playerVars = player.getData(PowerModVariables.PLAYER_VARIABLES);
            playerVars.power += STAR_POINTS_AMOUNT;
        }
    }
}