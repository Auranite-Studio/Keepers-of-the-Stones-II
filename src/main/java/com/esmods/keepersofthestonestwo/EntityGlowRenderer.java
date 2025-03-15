package com.esmods.keepersofthestonestwo;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.api.distmarker.Dist;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.MultiBufferSource;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@EventBusSubscriber(modid = "power", bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class EntityGlowRenderer {
	private static final Map<UUID, GlowSettings> GLOW_ENTITIES = new ConcurrentHashMap<>();
	private static final Set<UUID> RENDERING_ENTITIES = ConcurrentHashMap.newKeySet();
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

	// Клиентские методы для обработки сетевых пакетов
	public static void handleGlowUpdate(UUID entityId, boolean enabled, float red, float green, float blue) {
		GLOW_ENTITIES.compute(entityId, (k, v) -> {
			if (v == null) return new GlowSettings(red, green, blue);
			v.red = red;
			v.green = green;
			v.blue = blue;
			v.enabled = enabled;
			return v;
		});
	}

	@SubscribeEvent
	public static void onLivingRender(RenderLivingEvent.Post<LivingEntity, ?> event) {
		LivingEntity entity = event.getEntity();
		UUID entityId = entity.getUUID();

		if (!RENDERING_ENTITIES.contains(entityId)) {
			GlowSettings settings = GLOW_ENTITIES.get(entityId);
			if (settings != null && settings.enabled) {
				RENDERING_ENTITIES.add(entityId);
				try {
					renderGlowEffect(
							event.getRenderer(),
							entity,
							event.getPoseStack(),
							event.getMultiBufferSource(),
							event.getPackedLight(),
							event.getPartialTick(),
							settings
					);
				} finally {
					RENDERING_ENTITIES.remove(entityId);
				}
			}
		}
	}

	private static void renderGlowEffect(
			LivingEntityRenderer<LivingEntity, ?> renderer,
			LivingEntity entity,
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

		poseStack.translate(0, 0, 0.001);
		poseStack.scale(1.02f, 1.02f, 1.02f);

		renderHelper(
				renderer,
				entity,
				entity.getYRot(),
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
			LivingEntityRenderer<LivingEntity, ?> renderer,
			LivingEntity entity,
			float entityYaw,
			float partialTicks,
			PoseStack poseStack,
			MultiBufferSource bufferSource,
			int packedLight
	) {
		renderer.render(
				entity,
				entityYaw,
				partialTicks,
				poseStack,
				bufferSource,
				packedLight
		);
	}
}