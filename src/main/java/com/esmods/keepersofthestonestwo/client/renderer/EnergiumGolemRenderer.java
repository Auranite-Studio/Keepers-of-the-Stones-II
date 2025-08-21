package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.animation.KeyframeAnimation;

import com.esmods.keepersofthestonestwo.entity.EnergiumGolemEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.energium_golemAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelenergium_golem;

public class EnergiumGolemRenderer extends MobRenderer<EnergiumGolemEntity, LivingEntityRenderState, Modelenergium_golem> {
	private EnergiumGolemEntity entity = null;

	public EnergiumGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelenergium_golem.LAYER_LOCATION)), 1.125f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(EnergiumGolemEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/energium_golem.png");
	}

	private static final class AnimatedModel extends Modelenergium_golem {
		private EnergiumGolemEntity entity = null;
		private final KeyframeAnimation keyframeAnimation0;
		private final KeyframeAnimation keyframeAnimation1;
		private final KeyframeAnimation keyframeAnimation2;
		private final KeyframeAnimation keyframeAnimation3;
		private final KeyframeAnimation keyframeAnimation4;
		private final KeyframeAnimation keyframeAnimation5;

		public AnimatedModel(ModelPart root) {
			super(root);
			this.keyframeAnimation0 = energium_golemAnimation.idle.bake(root);
			this.keyframeAnimation1 = energium_golemAnimation.walk.bake(root);
			this.keyframeAnimation2 = energium_golemAnimation.death.bake(root);
			this.keyframeAnimation3 = energium_golemAnimation.shoot.bake(root);
			this.keyframeAnimation4 = energium_golemAnimation.attack.bake(root);
			this.keyframeAnimation5 = energium_golemAnimation.walk.bake(root);
		}

		public void setEntity(EnergiumGolemEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.keyframeAnimation0.apply(entity.animationState0, state.ageInTicks, 1f);
			this.keyframeAnimation1.apply(entity.animationState1, state.ageInTicks, 1f);
			this.keyframeAnimation2.apply(entity.animationState2, state.ageInTicks, 1f);
			this.keyframeAnimation3.apply(entity.animationState3, state.ageInTicks, 1f);
			this.keyframeAnimation4.apply(entity.animationState4, state.ageInTicks, 1f);
			this.keyframeAnimation5.apply(entity.animationState5, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}