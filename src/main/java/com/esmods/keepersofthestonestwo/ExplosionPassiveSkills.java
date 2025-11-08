package your.modid.common.event;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.function.Predicate;

@EventBusSubscriber
public class ExplosionPassiveSkills {

    // Проверка: есть ли эффект и нужные предметы
    private static boolean isActive(Player player) {
        if (player.level().isClientSide()) return false;
        if (!player.hasEffect(PowerModMobEffects.EXPLOSION_MASTER)) return false;

        // Проверяем инвентарь на наличие TNT или пороха
        return player.getInventory().contains((new ItemStack(Items.TNT))) || player.getInventory().contains((new ItemStack(Items.GUNPOWDER)));
    }

    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent.Pre event) {
        if (!(event.getSource().getEntity() instanceof Player attacker)) return;
        if (!isActive(attacker)) return;

        event.setNewDamage(event.getOriginalDamage() * 1.2f);
    }

    @SubscribeEvent
    public static void onPlayerKilledByEntity(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!isActive(player)) return;

        // Проверяем: был ли убит сущностью?
        var source = event.getSource();
        var attacker = source.getEntity();

        // Условие: атакующий — LivingEntity (моб или игрок), и он не сам игрок (самоубийство через зелье и т.п. не считается)
        if (attacker instanceof LivingEntity && attacker != player) {
            explodePlayer(player);
        }
    }


    // === Пассив 2: Сапёрский инвентарь — иммунитет к взрывам ===
    @SubscribeEvent
    public static void onExplosionDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!isActive(player)) return;

        // Проверка: урон от взрыва?
        if (event.getSource().is(DamageTypes.EXPLOSION)) {
            event.setCanceled(true); // полностью блокируем урон
        }
    }

    // Создаём взрыв при смерти игрока
    private static void explodePlayer(Player player) {
        if (player.level() instanceof ServerLevel serverLevel) {
            // Радиус взрыва = 3 (как у крипера)
            serverLevel.explode(
                    player,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    3.0f,
                    Level.ExplosionInteraction.MOB
            );
        }
    }
}