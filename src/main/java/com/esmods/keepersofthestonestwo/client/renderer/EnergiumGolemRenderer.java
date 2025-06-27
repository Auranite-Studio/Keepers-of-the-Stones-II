package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

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

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(EnergiumGolemEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.animationState0, energium_golemAnimation.idle, state.ageInTicks, 1f);
			this.animate(entity.animationState1, energium_golemAnimation.walk, state.ageInTicks, 1f);
			this.animate(entity.animationState2, energium_golemAnimation.death, state.ageInTicks, 1f);
			this.animate(entity.animationState3, energium_golemAnimation.shoot, state.ageInTicks, 1f);
			this.animate(entity.animationState4, energium_golemAnimation.attack, state.ageInTicks, 1f);
			this.animate(entity.animationState5, energium_golemAnimation.walk, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}