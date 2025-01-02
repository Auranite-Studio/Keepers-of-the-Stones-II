
package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.HierarchicalModel;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.cursed_knightAnimation;

public class CursedKnightRenderer extends HumanoidMobRenderer<CursedKnightEntity, HumanoidModel<CursedKnightEntity>> {
	public CursedKnightRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelLayers.PLAYER)), 0.75f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(CursedKnightEntity entity) {
		return new ResourceLocation("power:textures/entities/cursed_knight.png");
	}

	private static final class AnimatedModel extends HumanoidModel<CursedKnightEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CursedKnightEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CursedKnightEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, cursed_knightAnimation.walk, ageInTicks, 1f);
				this.animate(entity.animationState1, cursed_knightAnimation.idle, ageInTicks, 1f);
				this.animate(entity.animationState2, cursed_knightAnimation.sprint, ageInTicks, 1f);
				this.animate(entity.animationState3, cursed_knightAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CursedKnightEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
