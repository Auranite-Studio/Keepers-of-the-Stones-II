package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class RainPassiveSkills {

	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
		if (!(attacker instanceof ServerPlayer player)) return;
		if (!player.hasEffect(PowerModMobEffects.RAIN_MASTER)) return;
		if (!isPlayerOutsideDuringRain(player)) return;

		float original = event.getOriginalDamage();
		event.setNewDamage(original * 1.15f);
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (!(player instanceof ServerPlayer serverPlayer)) return;
		if (!serverPlayer.hasEffect(PowerModMobEffects.RAIN_MASTER)) return;
		if (!isPlayerOutsideDuringRain(serverPlayer)) return;
		if (serverPlayer.level().isClientSide()) return;

		if (serverPlayer.getFoodData().getFoodLevel() >= 18 && serverPlayer.getHealth() < serverPlayer.getMaxHealth()) {
			if (serverPlayer.tickCount % 64 == 0) {
				serverPlayer.heal(1.0f);
			}
		}
	}

	private static boolean isPlayerOutsideDuringRain(ServerPlayer player) {
		var level = player.level();
		return level.isRaining() && level.canSeeSky(player.blockPosition().above());
	}
}