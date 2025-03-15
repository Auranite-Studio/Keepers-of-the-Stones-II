package com.esmods.keepersofthestonestwo;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

@EventBusSubscriber(modid = "power", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class EntityGlowRenderer {
    private static boolean RENDERING = false;
    public static boolean GLOW_ENABLED = false;
    public static float RED;
    public static float GREEN;
    public static float BLUE;
    private static final float GLOW_ALPHA = 1.0f;

    @SubscribeEvent
    public static void onRenderLiving(RenderLivingEvent.Post<?, ?> event) {
        if (!RENDERING && GLOW_ENABLED) {
            RENDERING = true;
            try {
                renderGlowEffect(
                    event.getRenderer(),
                    event.getEntity(),
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
            LivingEntityRenderer<?, ?> renderer,
            LivingEntity entity,
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

        final float scale = 1.05f;
        final float[][] offsets = {
            {0.03F, 0}, {-0.03F, 0},
            {0, 0.03F}, {0, -0.03F}
        };

        for (float[] offset : offsets) {
            poseStack.pushPose();
            poseStack.translate(offset[0], offset[1], 0.001F);
            poseStack.scale(scale, scale, scale);
            renderEntityModel((LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>>) renderer, entity, poseStack, bufferSource, packedLight, partialTick);
            poseStack.popPose();
        }

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        poseStack.popPose();
    }

    private static void renderEntityModel(
            LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>> renderer,
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