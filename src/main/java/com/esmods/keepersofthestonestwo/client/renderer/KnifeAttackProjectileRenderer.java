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

import com.esmods.keepersofthestonestwo.entity.KnifeAttackProjectileEntity;
import com.esmods.keepersofthestonestwo.client.model.Modelknife;

public class KnifeAttackProjectileRenderer extends EntityRenderer<KnifeAttackProjectileEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("power:textures/entities/knife.png");
	private final Modelknife model;

	public KnifeAttackProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelknife(context.bakeLayer(Modelknife.LAYER_LOCATION));
	}

	@Override
	public void render(KnifeAttackProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(KnifeAttackProjectileEntity entity) {
		return texture;
	}
}
