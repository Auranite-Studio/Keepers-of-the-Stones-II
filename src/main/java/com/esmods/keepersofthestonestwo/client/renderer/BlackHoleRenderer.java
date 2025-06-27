package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.esmods.keepersofthestonestwo.entity.BlackHoleEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.black_holeAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelblack_hole;

public class BlackHoleRenderer extends MobRenderer<BlackHoleEntity, Modelblack_hole<BlackHoleEntity>> {
	public BlackHoleRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelblack_hole.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackHoleEntity entity) {
		return ResourceLocation.parse("power:textures/entities/black_hole.png");
	}

	private static final class AnimatedModel extends Modelblack_hole<BlackHoleEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BlackHoleEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BlackHoleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, black_holeAnimation.idle, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BlackHoleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}