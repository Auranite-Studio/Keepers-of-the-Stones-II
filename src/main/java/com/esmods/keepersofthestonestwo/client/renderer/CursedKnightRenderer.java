
package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.cursed_knightAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelcursed_knight;

public class CursedKnightRenderer extends MobRenderer<CursedKnightEntity, LivingEntityRenderState, Modelcursed_knight> {
	private CursedKnightEntity entity = null;

	public CursedKnightRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelcursed_knight.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(CursedKnightEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/cursed_knight.png");
	}

	private static final class AnimatedModel extends Modelcursed_knight {
		private CursedKnightEntity entity = null;

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(CursedKnightEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.animationState0, cursed_knightAnimation.walk, state.ageInTicks, 1f);
			this.animate(entity.animationState1, cursed_knightAnimation.idle, state.ageInTicks, 1f);
			this.animate(entity.animationState2, cursed_knightAnimation.sprint, state.ageInTicks, 1f);
			this.animate(entity.animationState3, cursed_knightAnimation.attack, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}
