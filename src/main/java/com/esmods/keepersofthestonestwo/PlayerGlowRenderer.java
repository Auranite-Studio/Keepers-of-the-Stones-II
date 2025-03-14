package com.esmods.keepersofthestonestwo;

import net.minecraft.client.player.AbstractClientPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.api.distmarker.Dist;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;

@EventBusSubscriber(modid = "power", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class PlayerGlowRenderer {
    private static boolean RENDERING = false;
    public static boolean GLOW_ENABLED = false;
    public static float RED;
    public static float GREEN;
    public static float BLUE;
    private static final float GLOW_ALPHA = 1.0f; // Полная непрозрачность

    @SubscribeEvent
    public static void onPlayerRender(RenderPlayerEvent.Post event) {
        if (!RENDERING && GLOW_ENABLED) {
            RENDERING = true;
            try {
                renderOutline(
                        event.getRenderer(),
                        (AbstractClientPlayer) event.getEntity(),
                        event.getPoseStack(),
                        event.getMultiBufferSource(),
                        event.getPackedLight(),
                        event.getPartialTick()
                );
            } finally {
                RENDERING = false;
            }
        }
    }

    private static void renderOutline(
            PlayerRenderer renderer,
            AbstractClientPlayer player,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            float partialTick
    ) {
        poseStack.pushPose();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);

        // Устанавливаем цвет обводки
        RenderSystem.setShaderColor(RED, GREEN, BLUE, GLOW_ALPHA);

        // Параметры контура
        final float scaleFactor = 1.05f;
        final float[][] offsets = {
                {0.03F, 0}, { -0.03F, 0 },
                {0, 0.03F}, {0, -0.03F}
        };

        // Рендер контурных слоев
        for (float[] offset : offsets) {
            poseStack.pushPose();
            poseStack.translate(offset[0], offset[1], 0.001F);
            poseStack.scale(scaleFactor, scaleFactor, scaleFactor);
            renderPlayerModel(renderer, player, poseStack, bufferSource, packedLight, partialTick);
            poseStack.popPose();
        }

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        poseStack.popPose();
    }

    private static void renderPlayerModel(
            PlayerRenderer renderer,
            AbstractClientPlayer player,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            float partialTick
    ) {
        renderer.render(
                player,
                player.getYRot(),
                partialTick,
                poseStack,
                bufferSource,
                packedLight
        );
    }
}