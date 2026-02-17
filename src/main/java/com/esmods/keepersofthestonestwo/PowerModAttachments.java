package com.esmods.keepersofthestonestwo;

import com.esmods.keepersofthestonestwo.PowerMod;
import com.esmods.keepersofthestonestwo.ElementType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Класс для регистрации и работы с Data Attachments мода.
 */
public class PowerModAttachments {

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PowerMod.MODID);

    // ==================== ATTACHMENTS ====================

    /**
     * Хранилище накопленных очков элементального урона для LivingEntity.
     * ИСПРАВЛЕНО: Явное указание типов в builder()
     */
    public static final Supplier<AttachmentType<Map<ElementType, Integer>>> ELEMENT_ACCUMULATOR =
            ATTACHMENT_TYPES.register("element_accumulator", () ->
                    AttachmentType.<Map<ElementType, Integer>>builder(() -> new HashMap<ElementType, Integer>()).build()
            );

    // ==================== РЕГИСТРАЦИЯ ====================

    public static void register(IEventBus modEventBus) {
        ATTACHMENT_TYPES.register(modEventBus);
    }

    // ==================== УТИЛИТЫ ДЛЯ ДОСТУПА ====================

    public static Map<ElementType, Integer> getAccumulator(LivingEntity entity) {
        return entity.getData(ELEMENT_ACCUMULATOR.get());
    }

    public static void addPoints(LivingEntity entity, ElementType type, int amount) {
        Map<ElementType, Integer> acc = getAccumulator(entity);
        acc.put(type, acc.getOrDefault(type, 0) + amount);
    }

    public static int getPoints(LivingEntity entity, ElementType type) {
        return getAccumulator(entity).getOrDefault(type, 0);
    }

    public static void setPoints(LivingEntity entity, ElementType type, int amount) {
        getAccumulator(entity).put(type, amount);
    }

    public static void resetPoints(LivingEntity entity, ElementType type) {
        getAccumulator(entity).put(type, 0);
    }

    public static boolean hasReachedThreshold(LivingEntity entity, ElementType type, int threshold) {
        return getPoints(entity, type) >= threshold;
    }

    public static void clearAllPoints(LivingEntity entity) {
        getAccumulator(entity).clear();
    }
}