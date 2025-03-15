package com.esmods.keepersofthestonestwo;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@EventBusSubscriber(modid = "power", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class EntityGlowRenderer {
    private static boolean RENDERING = false;
    private static final float GLOW_ALPHA = 1.0f;

    public static class GlowColor {
        public final float red;
        public final float green;
        public final float blue;

        public GlowColor(float r, float g, float b) {
            red = r;
            green = g;
            blue = b;
        }
    }

    private static final Map<UUID, GlowColor> TARGETS = new ConcurrentHashMap<>();

    public static void addTarget(LivingEntity entity, GlowColor color) {
        TARGETS.put(entity.getUUID(), color);
    }

    public static void removeTarget(LivingEntity entity) {
        TARGETS.remove(entity.getUUID());
    }

    public static void updateColor(LivingEntity entity, GlowColor newColor) {
        TARGETS.computeIfPresent(entity.getUUID(), (k, v) -> newColor);
    }

    public static void clearAllTargets() {
        TARGETS.clear();
    }

    @SubscribeEvent
    @SuppressWarnings("unchecked")
    public static void onRenderLiving(RenderLivingEvent.Post<?, ?> event) {
        if (!(event.getEntity() instanceof LivingEntity entity)) return;

        UUID uuid = entity.getUUID();
        if (RENDERING || !TARGETS.containsKey(uuid)) return;

        RENDERING = true;
        try {
            GlowColor color = TARGETS.get(uuid);
            renderGlowEffect(
                    (LivingEntityRenderer<LivingEntity, ?>) event.getRenderer(),
                    entity,
                    event.getPoseStack(),
                    event.getMultiBufferSource(),
                    event.getPackedLight(),
                    event.getPartialTick(),
                    color
            );
        } finally {
            RENDERING = false;
        }
    }

    private static void renderGlowEffect(
            LivingEntityRenderer<LivingEntity, ?> renderer,
            LivingEntity entity,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            float partialTick,
            GlowColor color
    ) {
        poseStack.pushPose();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        RenderSystem.setShaderColor(color.red, color.green, color.blue, GLOW_ALPHA);

        // Новые параметры для эффекта
        final float baseScale = 1.12f;
        final float zOffset = -0.01f; // Смещение перед основной моделью
        final int layers = 8; // Количество слоев для свечения
        final float scaleStep = 0.008f;

        // Рендерим несколько слоев с разным масштабом
        for (int i = 0; i < layers; i++) {
            poseStack.pushPose();
            float currentScale = baseScale + i * scaleStep;
            poseStack.translate(0, 0, zOffset + i * 0.001f);
            poseStack.scale(currentScale, currentScale, currentScale);
            renderEntityModel(renderer, entity, poseStack, bufferSource, packedLight, partialTick);
            poseStack.popPose();
        }

        // Восстанавливаем настройки
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        poseStack.popPose();
    }

    private static void renderEntityModel(
            LivingEntityRenderer<LivingEntity, ?> renderer,
            LivingEntity entity,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            float partialTick
    ) {
        renderer.render(
                entity,
                entity.getYRot(),
                partialTick,
                poseStack,
                bufferSource,
                packedLight
        );
    }
}