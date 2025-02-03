
package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

import com.esmods.keepersofthestonestwo.entity.BlackHoleEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.black_holeAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelblack_hole;

public class BlackHoleRenderer extends MobRenderer<BlackHoleEntity, LivingEntityRenderState, Modelblack_hole> {
	private BlackHoleEntity entity = null;

	public BlackHoleRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelblack_hole.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(BlackHoleEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/black_hole.png");
	}

	private static final class AnimatedModel extends Modelblack_hole {
		private BlackHoleEntity entity = null;

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(BlackHoleEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.animationState0, black_holeAnimation.idle, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}
