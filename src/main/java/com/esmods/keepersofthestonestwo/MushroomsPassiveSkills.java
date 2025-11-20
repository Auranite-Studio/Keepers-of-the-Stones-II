package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class MushroomsPassiveSkills {

	private static final int NAUSEA_DURATION = 20 * 20; // 20 секунд
	private static final int SEARCH_RADIUS = 16;

	// Проверка: активен ли MushroomsMaster и рядом грибы
	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.MUSHROOMS_MASTER)) return false;

		BlockPos center = player.blockPosition();
		for (int x = -SEARCH_RADIUS; x <= SEARCH_RADIUS; x++) {
			for (int y = -SEARCH_RADIUS; y <= SEARCH_RADIUS; y++) {
				for (int z = -SEARCH_RADIUS; z <= SEARCH_RADIUS; z++) {
					BlockPos pos = center.offset(x, y, z);
					var state = player.level().getBlockState(pos);

					// Проверяем грибы и грибные блоки
					if (state.is(Blocks.RED_MUSHROOM) ||
							state.is(Blocks.BROWN_MUSHROOM) ||
							state.is(Blocks.CRIMSON_FUNGUS) ||
							state.is(Blocks.WARPED_FUNGUS) ||
							state.is(Blocks.MUSHROOM_STEM) ||
							state.is(Blocks.BROWN_MUSHROOM_BLOCK) ||
							state.is(Blocks.RED_MUSHROOM_BLOCK) ||
							state.is(Blocks.MYCELIUM) ||
							state.is(Blocks.CRIMSON_NYLIUM) ||
							state.is(Blocks.WARPED_NYLIUM) ||
							state.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// === Основной пассив: Яд мухомора ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!(event.getEntity() instanceof LivingEntity target)) return;
		if (!isActive(attacker)) return;

		// +10% урона
		event.setNewDamage(event.getOriginalDamage() * 1.1f);

		// 15% шанс наложить Тошноту IV (амплifier = 3)
		if (attacker.getRandom().nextFloat() < 0.15f) {
			target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, NAUSEA_DURATION, 3, false, true));
		}
	}

	// === Дополнительный пассив: Ножка белого гриба ===
	@SubscribeEvent
	public static void onPlayerTakeDamage(LivingDamageEvent.Pre event) {
		if (!(event.getEntity() instanceof Player player)) return;
		if (!isActive(player)) return;

		// 15% шанс восстановить 4 единицы голода
		if (player.getRandom().nextFloat() < 0.15f) {
			// Восстанавливаем 4 hunger points (максимум — 20)
			int current = player.getFoodData().getFoodLevel();
			player.getFoodData().setFoodLevel(Math.min(20, current + 4));
		}
	}
}