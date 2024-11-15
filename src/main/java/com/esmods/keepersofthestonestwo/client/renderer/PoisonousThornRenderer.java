package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import com.esmods.keepersofthestonestwo.entity.PoisonousThornEntity;
import com.esmods.keepersofthestonestwo.client.model.Modelpoisonous_thorn;

public class PoisonousThornRenderer extends EntityRenderer<PoisonousThornEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("power:textures/entities/poisonous_thorn.png");
	private final Modelpoisonous_thorn model;

	public PoisonousThornRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelpoisonous_thorn(context.bakeLayer(Modelpoisonous_thorn.LAYER_LOCATION));
	}

	@Override
	public void render(PoisonousThornEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(PoisonousThornEntity entity) {
		return texture;
	}
}
