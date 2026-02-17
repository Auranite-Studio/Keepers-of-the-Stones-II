package com.esmods.keepersofthestonestwo;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.Optional;

@EventBusSubscriber(modid = PowerMod.MODID)
public class ElementalWeaponTooltipHandler {

	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();

		// ✅ Получаем элемент и множитель с приоритетом компонент > реестр
		ElementType type = ElementalWeaponUtils.getElementType(stack);
		float accumMultiplier = ElementalWeaponUtils.getAccumulationMultiplier(stack);

		if (type != null) {
			// ✅ Добавляем строку с элементом в подсказку
			Component elementText = getElementText(type);
			event.getToolTip().add(1, elementText);

			// ✅ Добавляем множитель накопления
			if (accumMultiplier != 1.0f) {
				String accumText = String.format("Множитель накопления: x%", accumMultiplier);
				event.getToolTip().add(Component.literal(accumText)
						.withStyle(s -> s.withColor(0x00AA00)));
			}
		}
	}

	/**
	 * Возвращает текст элемента с цветом.
	 */
	private static Component getElementText(ElementType type) {
		return switch (type) {
			case FIRE -> Component.literal("🔥 Огненный урон").withStyle(s -> s.withColor(0xFF5500));
			case PHYSICAL -> Component.literal("⚔️ Физический урон").withStyle(s -> s.withColor(0xFFAA00));
			default -> Component.literal("✨ " + type.name() + " урон").withStyle(s -> s.withColor(0xFFFFFF));
		};
	}
}