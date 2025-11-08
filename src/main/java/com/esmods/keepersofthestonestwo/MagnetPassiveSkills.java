package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.init.PowerModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class MagnetPassiveSkills {

	private static final int SEARCH_RADIUS = 16;
	private static final int ITEM_ATTRACT_RADIUS = 16;
	private static final double ATTRACT_SPEED = 0.2; // скорость притяжения

	private static boolean isActive(Player player) {
		if (player.level().isClientSide()) return false;
		if (!player.hasEffect(PowerModMobEffects.MAGNET_MASTER)) return false;

		BlockPos center = player.blockPosition();
		for (int x = -SEARCH_RADIUS; x <= SEARCH_RADIUS; x++) {
			for (int y = -SEARCH_RADIUS; y <= SEARCH_RADIUS; y++) {
				for (int z = -SEARCH_RADIUS; z <= SEARCH_RADIUS; z++) {
					BlockPos pos = center.offset(x, y, z);
					var block = player.level().getBlockState(pos).getBlock();
					if (block == Blocks.COPPER_BLOCK || block == Blocks.IRON_BLOCK) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// === Основной пассив: Сопротивление полюса ===
	@SubscribeEvent
	public static void onPlayerAttack(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getEntity() instanceof Player attacker)) return;
		if (!isActive(attacker)) return;

		// +20% урона
		event.setNewDamage(event.getOriginalDamage() * 1.2f);

		// 20% шанс оттолкнуть цель
		if (attacker.getRandom().nextFloat() < 0.2f) {
			Entity target = event.getEntity();
			// Отталкиваем от атакующего
			Vec3 direction = target.position().subtract(attacker.position()).normalize();
			if (direction.lengthSqr() < 1e-6) {
				direction = new Vec3(0, 0, 1); // fallback
			}
			// Применяем импульс (только на сервере)
			if (!target.level().isClientSide() && target instanceof net.minecraft.world.entity.LivingEntity living) {
				living.push(direction.x * 1.0, 0.4, direction.z * 1.0);
				living.hurtMarked = true;
			}
		}
	}

	// === Дополнительный пассив: Магнитное поле ===
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (!(player instanceof ServerPlayer)) return;
		if (!isActive(player)) return;

		// Притягиваем предметы в радиусе 16 блоков
		var entities = player.level().getEntitiesOfClass(
				ItemEntity.class,
				player.getBoundingBox().inflate(ITEM_ATTRACT_RADIUS)
		);

		Vec3 playerPos = player.position();
		for (ItemEntity item : entities) {
			if (item.isRemoved() || item.isNoGravity()) continue;

			Vec3 itemPos = item.position();
			Vec3 direction = playerPos.subtract(itemPos);
			double distance = direction.length();

			if (distance > 0.5) {
				direction = direction.normalize();
				// Добавляем импульс к предмету
				item.setDeltaMovement(
						item.getDeltaMovement().add(
								direction.x * ATTRACT_SPEED,
								direction.y * ATTRACT_SPEED * 0.5, // меньше по Y
								direction.z * ATTRACT_SPEED
						)
				);
				item.hurtMarked = true;
			}
		}
	}
}