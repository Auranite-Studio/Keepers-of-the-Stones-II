package com.esmods.keepersofthestonestwo;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Display.TextDisplay;
import net.minecraft.world.entity.Display.BillboardConstraints;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.Arrays;

@EventBusSubscriber(modid = PowerMod.MODID)
public class ElementDamageHandler {

	private static float baseAccumulation = 1.0f;
	private static final int THRESHOLD = 100;
	private static final int DAMAGE_NUMBER_LIFETIME = 20;
	private static final int STATUS_TEXT_LIFETIME = 40;

	// Битовые флаги для TextDisplay (из декомпилированного кода)
	private static final byte FLAG_SHADOW = 1;
	private static final byte FLAG_SEE_THROUGH = 2;
	private static final byte FLAG_DEFAULT_BACKGROUND = 4;
	// Выравнивание: 0 = Center, 8 = Left, 16 = Right

	@SubscribeEvent
	public static void onLivingHurt(LivingDamageEvent.Pre event) {
		LivingEntity target = event.getEntity();
		DamageSource source = event.getSource();

		ElementType type = getElementTypeFromSource(source);
		if (type == null) return;

		PowerModAttachments.addPoints(target, type, (int) baseAccumulation);
		spawnDamageNumber(target, event.getOriginalDamage(), type);

		if (PowerModAttachments.hasReachedThreshold(target, type, THRESHOLD)) {
			applyThresholdEffect(target, type, event);
			PowerModAttachments.resetPoints(target, type);
		}
	}

	private static ElementType getElementTypeFromSource(DamageSource source) {
		String msgId = source.type().msgId();
		return Arrays.stream(ElementType.values())
				.filter(type -> {
					String path = type.getDamageTypeId();
					int colonIndex = path.indexOf(':');
					return colonIndex >= 0 ? path.substring(colonIndex + 1).equals(msgId) : path.equals(msgId);
				})
				.findFirst()
				.orElse(null);
	}

	private static void applyThresholdEffect(LivingEntity target, ElementType type, LivingDamageEvent.Pre event) {
		PowerMod.LOGGER.info("🎯 THRESHOLD REACHED! Entity: {}, Type: {}", target.getName().getString(), type);

		switch (type) {
			case FIRE -> {
				target.igniteForSeconds(5);
				spawnStatusText(target, "🔥 OVERHEATING!", 0xFF5500);
			}
			case PHYSICAL -> {
				float originalDamage = event.getOriginalDamage();
				event.setNewDamage(originalDamage * 5.0f);
				spawnStatusText(target, "💥 CRIT DMG 500%!", 0xFFAA00);
			}
		}
	}

	private static void spawnDamageNumber(LivingEntity entity, float amount, ElementType type) {
		if (!(entity.level() instanceof ServerLevel serverLevel)) return;

		TextDisplay display = createTextDisplay(
				serverLevel,
				entity.getX(),
				entity.getY() + entity.getBbHeight() + 0.5,
				entity.getZ(),
				String.format("%.1f", amount),
				type == ElementType.FIRE ? 0xFF5500 : 0xFFFFFF
		);
		if (display != null) {
			serverLevel.addFreshEntity(display);
			PowerMod.queueServerWork(DAMAGE_NUMBER_LIFETIME, display::discard);
		}
	}

	private static void spawnStatusText(LivingEntity entity, String text, int color) {
		if (!(entity.level() instanceof ServerLevel serverLevel)) return;

		TextDisplay display = createTextDisplay(
				serverLevel,
				entity.getX(),
				entity.getY() + entity.getBbHeight() + 1.2,
				entity.getZ(),
				text,
				color
		);
		if (display != null) {
			serverLevel.addFreshEntity(display);
			PowerMod.queueServerWork(STATUS_TEXT_LIFETIME, display::discard);
		}
	}

	private static TextDisplay createTextDisplay(ServerLevel level, double x, double y, double z, String text, int color) {
		TextDisplay display = EntityType.TEXT_DISPLAY.create(level);
		if (display == null) return null;

		display.setPos(x, y, z);

		// === Настройка текста ===
		display.setText(Component.literal(text).withStyle(Style.EMPTY.withColor(color)));

		// Прозрачный фон (0x00000000)
		display.setBackgroundColor(0x00000000);

		// Настройка флагов: Тень (1) + Видимость сквозь блоки (2) + Центр (0) = 3
		// Если нужен фон по умолчанию, добавьте FLAG_DEFAULT_BACKGROUND (4)
		display.setFlags((byte) (FLAG_SHADOW | FLAG_SEE_THROUGH));

		// Масштаб текста (через setLineWidth можно влиять на перенос, но не на размер)
		display.setLineWidth(200);

		// === Billboard — всегда к игроку ===
		display.setBillboardConstraints(BillboardConstraints.CENTER);

		// === Физика ===
		display.setNoGravity(true);
		display.setInvulnerable(true);
		display.setSilent(true);
		display.setDeltaMovement(0, 0, 0);
		display.setViewRange(64.0f);

		// === Интерполяция ===
		display.setTransformationInterpolationDuration(0);
		display.setTransformationInterpolationDelay(0);
		display.setPosRotInterpolationDuration(0);

		return display;
	}

	// ==================== ПУБЛИЧНЫЙ API ====================

	public static void setBaseAccumulation(float value) {
		baseAccumulation = value;
	}

	public static float getBaseAccumulation() {
		return baseAccumulation;
	}

	public static void dealElementDamage(Entity target, ElementType type, float amount) {
		if (!(target.level() instanceof ServerLevel serverLevel)) {
			PowerMod.LOGGER.warn("dealElementDamage: not server level");
			return;
		}

		var damageTypeRegistry = serverLevel.registryAccess()
				.registryOrThrow(Registries.DAMAGE_TYPE);

		var rl = ResourceLocation.parse(type.getDamageTypeId());
		var damageTypeHolder = damageTypeRegistry.getHolder(rl);

		if (damageTypeHolder.isEmpty()) {
			PowerMod.LOGGER.error("Damage type NOT FOUND: {} - урон НЕ будет нанесён!", rl);
			return;
		}

		DamageSource source = new DamageSource(damageTypeHolder.get());
		target.hurt(source, amount);
	}

	public static void addElementPoints(LivingEntity entity, ElementType type, int points) {
		PowerModAttachments.addPoints(entity, type, points);
	}

	public static int getElementPoints(LivingEntity entity, ElementType type) {
		return PowerModAttachments.getPoints(entity, type);
	}

	public static void resetElementPoints(LivingEntity entity, ElementType type) {
		PowerModAttachments.resetPoints(entity, type);
	}

	public static int getAccumulationProgress(LivingEntity entity, ElementType type) {
		int points = getElementPoints(entity, type);
		return (points * 100) / THRESHOLD;
	}
}