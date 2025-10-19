package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class MusicPassiveSkills {

	private static final int WEAKNESS_DURATION = 10 * 20;     // 10 сек
	private static final int REGEN_DURATION = 15 * 20;        // 15 сек
	private static final int REGEN_COOLDOWN = 90 * 20;        // 90 сек
	private static final int SEARCH_RADIUS = 16;

	private static final Map<UUID, Long> lastRegenTime = new HashMap<>();

	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.MUSIC_MASTER)) return false;

		// Условие 1: рядом нотный блок или проигрыватель
		BlockPos center = player.blockPosition();
		for (int x = -SEARCH_RADIUS; x <= SEARCH_RADIUS; x++) {
			for (int y = -SEARCH_RADIUS; y <= SEARCH_RADIUS; y++) {
				for (int z = -SEARCH_RADIUS; z <= SEARCH_RADIUS; z++) {
					BlockPos pos = center.offset(x, y, z);
					var block = player.level().getBlockState(pos).getBlock();
					if (block == Blocks.NOTE_BLOCK || block == Blocks.JUKEBOX) {
						return true;
					}
				}
			}
		}

		// Условие 2: в инвентаре есть музыкальная пластинка (через тег)
		for (ItemStack stack : player.getInventory().items) {
			if (!stack.isEmpty() && stack.is(Tags.Items.MUSIC_DISCS)) {
				return true;
			}
		}
		// Проверяем offhand
		ItemStack offhand = player.getOffhandItem();
		return !offhand.isEmpty() && offhand.is(Tags.Items.MUSIC_DISCS);
	}

	// === Музыкальный ритм ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity target)) return;
		if (!isActive(attacker)) return;

		event.setNewDamage(event.getOriginalDamage() * 1.2f);

		if (attacker.getRandom().nextFloat() < 0.1f) {
			target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, WEAKNESS_DURATION, 2, false, true));
		}
	}

	// === Гармония ===
	@SubscribeEvent
	public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!isActive(player)) return;

		UUID id = player.getUUID();
		long now = player.level().getGameTime();
		Long last = lastRegenTime.get(id);

		if ((last == null || now - last >= REGEN_COOLDOWN) && player.getRandom().nextFloat() < 0.1f) {
			player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, REGEN_DURATION, 1, false, true));
			lastRegenTime.put(id, now);
		}
	}
}