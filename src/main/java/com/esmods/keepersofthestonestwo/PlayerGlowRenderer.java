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
import net.minecraft.world.entity.player.Player;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@EventBusSubscriber(modid = "power", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class PlayerGlowRenderer {
    private static final Map<UUID, GlowSettings> GLOW_PLAYERS = new ConcurrentHashMap<>();
    private static final Set<UUID> RENDERING_PLAYERS = ConcurrentHashMap.newKeySet();
    private static final float GLOW_ALPHA = 0.8f;

    private static class GlowSettings {
        boolean enabled;
        float red;
        float green;
        float blue;

        GlowSettings(float red, float green, float blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.enabled = true;
        }
    }

    // API методы для управления свечением
    public static void enableGlow(UUID playerId) {
        GLOW_PLAYERS.computeIfPresent(playerId, (k, v) -> {
            v.enabled = true;
            return v;
        });
    }

    public static void disableGlow(UUID playerId) {
        GLOW_PLAYERS.computeIfPresent(playerId, (k, v) -> {
            v.enabled = false;
            return v;
        });
    }

    public static void setGlowColor(UUID playerId, float red, float green, float blue) {
        GLOW_PLAYERS.compute(playerId, (k, v) -> {
            if (v == null) {
                return new GlowSettings(red, green, blue);
            }
            v.red = red;
            v.green = green;
            v.blue = blue;
            return v;
        });
    }

    public static void removeGlow(UUID playerId) {
        GLOW_PLAYERS.remove(playerId);
    }

    @SubscribeEvent
    public static void onPlayerRender(RenderPlayerEvent.Post event) {
        Player player = event.getEntity();
        UUID playerId = player.getUUID();

        if (!RENDERING_PLAYERS.contains(playerId)) {
            GlowSettings settings = GLOW_PLAYERS.get(playerId);
            if (settings != null && settings.enabled) {
                RENDERING_PLAYERS.add(playerId);
                try {
                    renderGlowEffect(
                            (PlayerRenderer) event.getRenderer(),
                            (AbstractClientPlayer) player,
                            event.getPoseStack(),
                            event.getMultiBufferSource(),
                            event.getPackedLight(),
                            event.getPartialTick(),
                            settings
                    );
                } finally {
                    RENDERING_PLAYERS.remove(playerId);
                }
            }
        }
    }

    private static void renderGlowEffect(
            PlayerRenderer renderer,
            AbstractClientPlayer player,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            float partialTick,
            GlowSettings settings
    ) {
        poseStack.pushPose();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        RenderSystem.setShaderColor(settings.red, settings.green, settings.blue, GLOW_ALPHA);

        // Настройки трансформации
        poseStack.translate(0, 0, 0.001);
        poseStack.scale(1.02f, 1.02f, 1.02f);

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