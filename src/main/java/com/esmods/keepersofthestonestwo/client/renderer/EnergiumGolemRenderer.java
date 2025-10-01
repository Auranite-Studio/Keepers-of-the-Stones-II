package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.esmods.keepersofthestonestwo.entity.EnergiumGolemEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.energium_golemAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelenergium_golem;

public class EnergiumGolemRenderer extends MobRenderer<EnergiumGolemEntity, Modelenergium_golem<EnergiumGolemEntity>> {
	public EnergiumGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelenergium_golem.LAYER_LOCATION)), 1.125f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnergiumGolemEntity entity) {
		return ResourceLocation.parse("power:textures/entities/energium_golem.png");
	}

	private static final class AnimatedModel extends Modelenergium_golem<EnergiumGolemEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<EnergiumGolemEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(EnergiumGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, energium_golemAnimation.idle, ageInTicks, 1f);
				this.animate(entity.animationState1, energium_golemAnimation.walk, ageInTicks, 1f);
				this.animate(entity.animationState2, energium_golemAnimation.death, ageInTicks, 1f);
				this.animate(entity.animationState3, energium_golemAnimation.shoot, ageInTicks, 1f);
				this.animate(entity.animationState4, energium_golemAnimation.attack, ageInTicks, 1f);
				this.animate(entity.animationState5, energium_golemAnimation.walk, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(EnergiumGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}