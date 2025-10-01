package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.mojang.blaze3d.vertex.PoseStack;

import com.esmods.keepersofthestonestwo.entity.TurretEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.turretAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelturret;

public class TurretRenderer extends MobRenderer<TurretEntity, Modelturret<TurretEntity>> {
	public TurretRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelturret.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(TurretEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(TurretEntity entity) {
		return ResourceLocation.parse("power:textures/entities/turret.png");
	}

	private static final class AnimatedModel extends Modelturret<TurretEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<TurretEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(TurretEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, turretAnimation.walk, ageInTicks, 1f);
				this.animate(entity.animationState1, turretAnimation.idle, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(TurretEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}