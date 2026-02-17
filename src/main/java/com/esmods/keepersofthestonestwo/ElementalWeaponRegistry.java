package com.esmods.keepersofthestonestwo;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 🔹 РЕЕСТР ЭЛЕМЕНТАЛЬНОГО ОРУЖИЯ 🔹
 *
 * Позволяет привязывать ElementType и множитель накопления к предметам.
 */
public class ElementalWeaponRegistry {

	// === ХРАНИЛИЩЕ: Item → WeaponData ===
	private static final Map<Item, WeaponData> WEAPON_DATA = new WeakHashMap<>();

	// === ПРИВАТНЫЙ КОНСТРУКТОР ===
	private ElementalWeaponRegistry() {}

	/**
	 * Регистрирует предмет как элементальное оружие с кастомным накоплением.
	 *
	 * @param item предмет
	 * @param type тип элемента
	 * @param accumulationMultiplier множитель накопления (1.0 = стандарт, 2.0 = двойное)
	 */
	public static void registerWeapon(Item item, ElementType type, float accumulationMultiplier) {
		if (item == null || type == null) return;
		WEAPON_DATA.put(item, new WeaponData(type, Math.max(0f, accumulationMultiplier)));
		PowerMod.LOGGER.debug("⚔️ Registered elemental weapon: {} → {} (accum: x{})",
				item.getDescriptionId(), type, accumulationMultiplier);
	}

	/**
	 * Регистрирует предмет со стандартным накоплением (множитель 1.0).
	 */
	public static void registerWeapon(Item item, ElementType type) {
		registerWeapon(item, type, 1.0f);
	}

	/**
	 * Получает данные оружия.
	 */
	public static WeaponData getWeaponData(ItemStack stack) {
		if (stack == null || stack.isEmpty()) return null;
		return WEAPON_DATA.get(stack.getItem());
	}

	/**
	 * Получает ElementType предмета.
	 */
	public static ElementType getElementType(ItemStack stack) {
		WeaponData data = getWeaponData(stack);
		return data != null ? data.type() : null;
	}

	/**
	 * Получает множитель накопления предмета.
	 * @return множитель или 1.0f если не зарегистрирован
	 */
	public static float getAccumulationMultiplier(ItemStack stack) {
		WeaponData data = getWeaponData(stack);
		return data != null ? data.accumulationMultiplier() : 1.0f;
	}

	/**
	 * Проверяет, является ли предмет элементальным оружием.
	 */
	public static boolean isElementalWeapon(ItemStack stack) {
		return getElementType(stack) != null;
	}

	/**
	 * Очищает реестр (для тестов).
	 */
	public static void clear() {
		WEAPON_DATA.clear();
	}

	/**
	 * Возвращает количество зарегистрированных предметов.
	 */
	public static int getRegisteredCount() {
		return WEAPON_DATA.size();
	}

	// === RECORD ДЛЯ ХРАНЕНИЯ ДАННЫХ ОРУЖИЯ ===
	public record WeaponData(ElementType type, float accumulationMultiplier) {
		@Override
		public String toString() {
			return String.format("WeaponData{type=%s, accum=x%.2f}", type, accumulationMultiplier);
		}
	}
}