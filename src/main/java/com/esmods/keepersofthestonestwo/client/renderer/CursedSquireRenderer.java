package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.cursed_squireAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelcursed_squire;

public class CursedSquireRenderer extends MobRenderer<CursedSquireEntity, Modelcursed_squire<CursedSquireEntity>> {
	public CursedSquireRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelcursed_squire.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CursedSquireEntity entity) {
		return ResourceLocation.parse("power:textures/entities/cursed_squire.png");
	}

	private static final class AnimatedModel extends Modelcursed_squire<CursedSquireEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CursedSquireEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CursedSquireEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, cursed_squireAnimation.walk, ageInTicks, 1f);
				this.animate(entity.animationState1, cursed_squireAnimation.walk, ageInTicks, 1f);
				this.animate(entity.animationState2, cursed_squireAnimation.idle, ageInTicks, 1f);
				this.animate(entity.animationState3, cursed_squireAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CursedSquireEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}