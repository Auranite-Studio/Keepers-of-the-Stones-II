package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

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

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(CursedSquireEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.animationState0, cursed_squireAnimation.walk, state.ageInTicks, 1f);
			this.animate(entity.animationState1, cursed_squireAnimation.walk, state.ageInTicks, 1f);
			this.animate(entity.animationState2, cursed_squireAnimation.idle, state.ageInTicks, 1f);
			this.animate(entity.animationState3, cursed_squireAnimation.attack, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}