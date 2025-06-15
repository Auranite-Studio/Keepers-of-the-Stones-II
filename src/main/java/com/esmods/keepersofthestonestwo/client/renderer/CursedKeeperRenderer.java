package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;

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

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(CursedKeeperEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.animationState0, cursed_keeperAnimation.run, state.ageInTicks, 1f);
			this.animate(entity.animationState1, cursed_keeperAnimation.walk, state.ageInTicks, 1f);
			this.animate(entity.animationState2, cursed_keeperAnimation.idle_no, state.ageInTicks, 1f);
			this.animate(entity.animationState3, cursed_keeperAnimation.idle, state.ageInTicks, 1f);
			this.animate(entity.animationState4, cursed_keeperAnimation.idle_ground, state.ageInTicks, 1f);
			this.animate(entity.animationState5, cursed_keeperAnimation.aggro, state.ageInTicks, 1f);
			this.animate(entity.animationState6, cursed_keeperAnimation.fall, state.ageInTicks, 1f);
			this.animate(entity.animationState7, cursed_keeperAnimation.summon_wave, state.ageInTicks, 1f);
			this.animate(entity.animationState8, cursed_keeperAnimation.firethrowing, state.ageInTicks, 1f);
			this.animate(entity.animationState9, cursed_keeperAnimation.wind_shield, state.ageInTicks, 1f);
			this.animate(entity.animationState10, cursed_keeperAnimation.stalagmite_piercing, state.ageInTicks, 1f);
			this.animate(entity.animationState11, cursed_keeperAnimation.water_healing, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}