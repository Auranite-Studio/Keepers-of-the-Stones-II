package your.modid.common.event;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class EnergyPassiveSkills {

    private static final Map<UUID, Long> lastAttackTime = new HashMap<>();
    private static final Map<UUID, Integer> attackStreak = new HashMap<>();

    private static final Map<UUID, Integer> hungerBeforeSprint = new HashMap<>();

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        if (!(source.getEntity() instanceof ServerPlayer attacker)) return;
        if (target.level().isClientSide()) return;

        if (!attacker.hasEffect(PowerModMobEffects.ENERGY_MASTER) || attacker.getFoodData().getFoodLevel() < 16) {
            return;
        }

        UUID uuid = attacker.getUUID();
        long currentTime = attacker.level().getGameTime();
        long lastTime = lastAttackTime.getOrDefault(uuid, -100L);
        int streak = attackStreak.getOrDefault(uuid, 0);

        if (currentTime - lastTime <= 60) { // <= 3 сек
            streak++;
        } else {
            streak = 1;
        }

        lastAttackTime.put(uuid, currentTime);
        attackStreak.put(uuid, streak);

        if (streak % 3 == 0) {
            event.setNewDamage(event.getOriginalDamage() * 1.5f);
        }
    }

    @SubscribeEvent
    public static void onPlayerTickPre(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;

        // Сохраняем голод ДО тика, если игрок в спринте и условия выполнены
        if (player.isSprinting() &&
                player.hasEffect(PowerModMobEffects.ENERGY_MASTER) &&
                player.getFoodData().getFoodLevel() >= 16) {
            hungerBeforeSprint.put(player.getUUID(), player.getFoodData().getFoodLevel());
        } else {
            hungerBeforeSprint.remove(player.getUUID());
        }
    }

    @SubscribeEvent
    public static void onPlayerTickPost(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;

        UUID uuid = player.getUUID();
        if (hungerBeforeSprint.containsKey(uuid)) {
            int prevHunger = hungerBeforeSprint.get(uuid);
            FoodData food = player.getFoodData();

            // Если голод уменьшился во время спринта — восстанавливаем
            if (food.getFoodLevel() < prevHunger) {
                food.setFoodLevel(prevHunger);
                // Насыщение не трогаем — оно не участвует в спринте
            }

            hungerBeforeSprint.remove(uuid);
        }
    }
}