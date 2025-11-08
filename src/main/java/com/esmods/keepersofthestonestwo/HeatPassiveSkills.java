package your.modid.common.event;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class HeatPassiveSkills {

	private static final int FIRE_DURATION = 3;
	private static final int FIRE_RESIST_DURATION = 60 * 20;
	private static final int REGEN_DURATION = 5 * 20;
	private static final int COOLDOWN = 90 * 20;

	private static final Map<UUID, Long> lastActivationTime = new HashMap<>();
	private static final Map<UUID, Boolean> wasBurning = new HashMap<>();

	private static boolean isInWarmOrTemperateBiome(Player player) {
		Biome biome = player.level().getBiome(player.blockPosition()).value();
		return biome.getModifiedClimateSettings().temperature() >= 0.2f;
	}

	private static boolean isActive(Player player) {
		return !player.level().isClientSide() &&
				player.hasEffect(PowerModMobEffects.HEAT_MASTER) &&
				isInWarmOrTemperateBiome(player);
	}

	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity target)) return;
		if (!isActive(attacker)) return;

		event.setNewDamage(event.getOriginalDamage() * 1.2f);

		if (attacker.getRandom().nextFloat() < 0.1f) {
			target.igniteForSeconds(FIRE_DURATION);
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof Player player)) return;
		UUID id = player.getUUID();

		if (!isActive(player)) {
			wasBurning.remove(id);
			lastActivationTime.remove(id);
			return;
		}

		boolean isBurning = player.isOnFire();
		Boolean wasBurningBefore = wasBurning.get(id);

		if (isBurning && (wasBurningBefore == null || !wasBurningBefore)) {
			long now = player.level().getGameTime();
			Long last = lastActivationTime.get(id);

			if (last == null || now - last >= COOLDOWN) {
				if (player.getRandom().nextFloat() < 0.75f) {
					player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, FIRE_RESIST_DURATION, 0, false, true));
					player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, REGEN_DURATION, 1, false, true));
					lastActivationTime.put(id, now);
				}
			}
		}

		wasBurning.put(id, isBurning);
	}
}