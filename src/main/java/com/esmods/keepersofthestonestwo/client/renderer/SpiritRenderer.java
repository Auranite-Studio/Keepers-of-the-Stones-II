
package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

import com.esmods.keepersofthestonestwo.entity.SpiritEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.spiritAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelspirit;

public class SpiritRenderer extends MobRenderer<SpiritEntity, LivingEntityRenderState, Modelspirit> {
	private SpiritEntity entity = null;

	public SpiritRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelspirit.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(SpiritEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/spirit.png");
	}

	private static final class AnimatedModel extends Modelspirit {
		private SpiritEntity entity = null;

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(SpiritEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.animationState0, spiritAnimation.idle, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}
