package com.esmods.keepersofthestonestwo;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

/**
 * 🔹 УТИЛИТЫ ДЛЯ ЭЛЕМЕНТАЛЬНОГО ОРУЖИЯ 🔹
 *
 * Позволяет добавлять элементальные свойства к существующим предметам.
 */
public class ElementalWeaponUtils {

    // === ПРИВАТНЫЙ КОНСТРУКТОР ===
    private ElementalWeaponUtils() {}

    /**
     * Регистрирует ванильный предмет как элементальное оружие со стандартным накоплением.
     */
    public static void registerVanillaItem(Item vanillaItem, ElementType type) {
        registerVanillaItem(vanillaItem, type, 1.0f);
    }

    /**
     * Регистрирует ванильный предмет как элементальное оружие с кастомным накоплением.
     *
     * @param vanillaItem ванильный предмет
     * @param type тип элемента
     * @param accumulationMultiplier множитель накопления (1.0 = стандарт, 2.0 = двойное)
     */
    public static void registerVanillaItem(Item vanillaItem, ElementType type, float accumulationMultiplier) {
        if (vanillaItem == null || type == null) return;
        ElementalWeaponRegistry.registerWeapon(vanillaItem, type, accumulationMultiplier);
        PowerMod.LOGGER.info("⚔️ Registered vanilla item {} as {} elemental (accum x{})",
                BuiltInRegistries.ITEM.getKey(vanillaItem), type, accumulationMultiplier);
    }

    /**
     * Регистрирует предмет по ResourceLocation со стандартным накоплением.
     */
    public static boolean registerItemById(String modId, String itemName, ElementType type) {
        return registerItemById(modId, itemName, type, 1.0f);
    }

    /**
     * Регистрирует предмет по ResourceLocation с кастомным накоплением.
     *
     * @param modId мод (например "minecraft" или "twilightforest")
     * @param itemName имя предмета (например "diamond_sword")
     * @param type тип элемента
     * @param accumulationMultiplier множитель накопления
     * @return true если предмет найден и зарегистрирован
     */
    public static boolean registerItemById(String modId, String itemName, ElementType type, float accumulationMultiplier) {
        ResourceLocation rl = ResourceLocation.fromNamespaceAndPath(modId, itemName);
        Optional<Item> itemOpt = BuiltInRegistries.ITEM.getOptional(rl);

        if (itemOpt.isPresent()) {
            ElementalWeaponRegistry.registerWeapon(itemOpt.get(), type, accumulationMultiplier);
            PowerMod.LOGGER.info("⚔️ Registered {}:{} as {} elemental (accum x{})", modId, itemName, type, accumulationMultiplier);
            return true;
        } else {
            PowerMod.LOGGER.warn("❌ Item not found: {}:{}", modId, itemName);
            return false;
        }
    }

    /**
     * Массовая регистрация со стандартным множителем.
     */
    @SafeVarargs
    public static void registerMultiple(ElementType type, Item... items) {
        registerMultiple(type, 1.0f, items);
    }

    /**
     * Массовая регистрация с кастомным множителем.
     */
    @SafeVarargs
    public static void registerMultiple(ElementType type, float accumulationMultiplier, Item... items) {
        if (items == null) return;
        for (Item item : items) {
            if (item != null) {
                ElementalWeaponRegistry.registerWeapon(item, type, accumulationMultiplier);
            }
        }
        PowerMod.LOGGER.info("⚔️ Registered {} items as {} elemental (accum x{})", items.length, type, accumulationMultiplier);
    }

    /**
     * Проверяет, является ли ItemStack элементальным (через реестр или компонент).
     */
    public static boolean isElemental(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return false;
        return ElementalWeaponRegistry.getElementType(stack) != null ||
                ElementalWeaponComponent.getElement(stack).isPresent();
    }

    /**
     * Получает ElementType из ItemStack с приоритетом: компонент > реестр.
     */
    public static ElementType getElementType(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return null;

        // Сначала проверяем компонент (более специфичный)
        Optional<ElementType> component = ElementalWeaponComponent.getElement(stack);
        if (component.isPresent()) {
            return component.get();
        }

        // Потом реестр (общий для всех таких предметов)
        return ElementalWeaponRegistry.getElementType(stack);
    }

    /**
     * Получает множитель накопления из ItemStack с приоритетом: компонент > реестр.
     */
    public static float getAccumulationMultiplier(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return 1.0f;

        // Сначала проверяем компонент (более специфичный)
        float componentAccum = ElementalWeaponComponent.getAccumMultiplier(stack);
        if (componentAccum != 1.0f) {
            return componentAccum;
        }

        // Потом реестр (общий для всех таких предметов)
        return ElementalWeaponRegistry.getAccumulationMultiplier(stack);
    }

    /**
     * Добавляет элемент к конкретному экземпляру ItemStack (через компонент).
     * Не влияет на другие такие же предметы!
     */
    public static ItemStack addElementToStack(ItemStack stack, ElementType type) {
        return addElementToStackWithAccum(stack, type, 1.0f);
    }

    /**
     * Добавляет элемент и множитель накопления к конкретному экземпляру ItemStack.
     */
    public static ItemStack addElementToStackWithAccum(ItemStack stack, ElementType type, float accumMultiplier) {
        if (stack == null || stack.isEmpty() || type == null) return stack;
        return ElementalWeaponComponent.withElementAndAccum(stack, type, accumMultiplier);
    }

    /**
     * Удаляет элемент с конкретного экземпляра ItemStack.
     */
    public static ItemStack removeElementFromStack(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return stack;
        return ElementalWeaponComponent.removeElement(stack);
    }
}