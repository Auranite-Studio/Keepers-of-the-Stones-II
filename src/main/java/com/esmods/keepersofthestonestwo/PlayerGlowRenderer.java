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
    private static final float GLOW_ALPHA = 0.8f;

    @SubscribeEvent
    public static void onPlayerRender(RenderPlayerEvent.Post event) {
        if (!RENDERING && GLOW_ENABLED) {
            RENDERING = true;
            try {
                renderGlowEffect(
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

    private static void renderGlowEffect(
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
        RenderSystem.setShaderColor(RED, GREEN, BLUE, GLOW_ALPHA);

        // Настройки трансформации
        poseStack.translate(0, 0, 0.001);
        poseStack.scale(1.02f, 1.02f, 1.02f);

        // Рендер через вспомогательный метод
        renderHelper(
                renderer,
                player,
                player.getYRot(),
                partialTick,
                poseStack,
                bufferSource,
                packedLight
        );

        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        poseStack.popPose();
    }

    private static void renderHelper(
            PlayerRenderer renderer,
            AbstractClientPlayer player,
            float entityYaw,
            float partialTicks,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight
    ) {
        // Прямой вызов внутреннего метода рендеринга
        renderer.render(
                player,
                entityYaw,
                partialTicks,
                poseStack,
                bufferSource,
                packedLight
        );
    }
}