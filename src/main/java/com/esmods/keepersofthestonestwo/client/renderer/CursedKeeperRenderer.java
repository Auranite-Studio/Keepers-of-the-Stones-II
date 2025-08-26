package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.animation.KeyframeAnimation;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.cursed_keeperAnimation;
import com.esmods.keepersofthestonestwo.client.model.Modelcursed_keeper;

public class CursedKeeperRenderer extends MobRenderer<CursedKeeperEntity, LivingEntityRenderState, Modelcursed_keeper> {
	private CursedKeeperEntity entity = null;

	public CursedKeeperRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelcursed_keeper.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(CursedKeeperEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/cursed_keeper.png");
	}

	private static final class AnimatedModel extends Modelcursed_keeper {
		private CursedKeeperEntity entity = null;
		private final KeyframeAnimation keyframeAnimation0;
		private final KeyframeAnimation keyframeAnimation1;
		private final KeyframeAnimation keyframeAnimation2;
		private final KeyframeAnimation keyframeAnimation3;
		private final KeyframeAnimation keyframeAnimation4;
		private final KeyframeAnimation keyframeAnimation5;
		private final KeyframeAnimation keyframeAnimation6;
		private final KeyframeAnimation keyframeAnimation7;
		private final KeyframeAnimation keyframeAnimation8;
		private final KeyframeAnimation keyframeAnimation9;
		private final KeyframeAnimation keyframeAnimation10;
		private final KeyframeAnimation keyframeAnimation11;

		public AnimatedModel(ModelPart root) {
			super(root);
			this.keyframeAnimation0 = cursed_keeperAnimation.run.bake(root);
			this.keyframeAnimation1 = cursed_keeperAnimation.walk.bake(root);
			this.keyframeAnimation2 = cursed_keeperAnimation.idle_no.bake(root);
			this.keyframeAnimation3 = cursed_keeperAnimation.idle.bake(root);
			this.keyframeAnimation4 = cursed_keeperAnimation.idle_ground.bake(root);
			this.keyframeAnimation5 = cursed_keeperAnimation.aggro.bake(root);
			this.keyframeAnimation6 = cursed_keeperAnimation.fall.bake(root);
			this.keyframeAnimation7 = cursed_keeperAnimation.summon_wave.bake(root);
			this.keyframeAnimation8 = cursed_keeperAnimation.firethrowing.bake(root);
			this.keyframeAnimation9 = cursed_keeperAnimation.wind_shield.bake(root);
			this.keyframeAnimation10 = cursed_keeperAnimation.stalagmite_piercing.bake(root);
			this.keyframeAnimation11 = cursed_keeperAnimation.water_healing.bake(root);
		}

		public void setEntity(CursedKeeperEntity entity) {
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
			this.keyframeAnimation6.apply(entity.animationState6, state.ageInTicks, 1f);
			this.keyframeAnimation7.apply(entity.animationState7, state.ageInTicks, 1f);
			this.keyframeAnimation8.apply(entity.animationState8, state.ageInTicks, 1f);
			this.keyframeAnimation9.apply(entity.animationState9, state.ageInTicks, 1f);
			this.keyframeAnimation10.apply(entity.animationState10, state.ageInTicks, 1f);
			this.keyframeAnimation11.apply(entity.animationState11, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}