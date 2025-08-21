package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.animation.KeyframeAnimation;

import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.cursed_squireAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelcursed_squire;

public class CursedSquireRenderer extends MobRenderer<CursedSquireEntity, LivingEntityRenderState, Modelcursed_squire> {
	private CursedSquireEntity entity = null;

	public CursedSquireRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelcursed_squire.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(CursedSquireEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/cursed_squire.png");
	}

	private static final class AnimatedModel extends Modelcursed_squire {
		private CursedSquireEntity entity = null;
		private final KeyframeAnimation keyframeAnimation0;
		private final KeyframeAnimation keyframeAnimation1;
		private final KeyframeAnimation keyframeAnimation2;
		private final KeyframeAnimation keyframeAnimation3;

		public AnimatedModel(ModelPart root) {
			super(root);
			this.keyframeAnimation0 = cursed_squireAnimation.walk.bake(root);
			this.keyframeAnimation1 = cursed_squireAnimation.walk.bake(root);
			this.keyframeAnimation2 = cursed_squireAnimation.idle.bake(root);
			this.keyframeAnimation3 = cursed_squireAnimation.attack.bake(root);
		}

		public void setEntity(CursedSquireEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.keyframeAnimation0.apply(entity.animationState0, state.ageInTicks, 1f);
			this.keyframeAnimation1.apply(entity.animationState1, state.ageInTicks, 1f);
			this.keyframeAnimation2.apply(entity.animationState2, state.ageInTicks, 1f);
			this.keyframeAnimation3.apply(entity.animationState3, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}