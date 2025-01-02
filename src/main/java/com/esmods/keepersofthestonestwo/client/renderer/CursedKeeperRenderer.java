
package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.HierarchicalModel;

import com.esmods.keepersofthestonestwo.entity.CursedKeeperEntity;
import com.esmods.keepersofthestonestwo.client.model.animations.cursed_keeperAnimation;

public class CursedKeeperRenderer extends HumanoidMobRenderer<CursedKeeperEntity, HumanoidModel<CursedKeeperEntity>> {
	public CursedKeeperRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(CursedKeeperEntity entity) {
		return new ResourceLocation("power:textures/entities/cursed_keeper.png");
	}

	private static final class AnimatedModel extends HumanoidModel<CursedKeeperEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CursedKeeperEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CursedKeeperEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, cursed_keeperAnimation.run, ageInTicks, 1f);
				this.animate(entity.animationState1, cursed_keeperAnimation.walk, ageInTicks, 1f);
				this.animate(entity.animationState2, cursed_keeperAnimation.idle_no, ageInTicks, 1f);
				this.animate(entity.animationState3, cursed_keeperAnimation.idle, ageInTicks, 1f);
				this.animate(entity.animationState4, cursed_keeperAnimation.idle_ground, ageInTicks, 1f);
				this.animate(entity.animationState5, cursed_keeperAnimation.aggro, ageInTicks, 1f);
				this.animate(entity.animationState6, cursed_keeperAnimation.fall, ageInTicks, 1f);
				this.animate(entity.animationState7, cursed_keeperAnimation.summon_wave, ageInTicks, 1f);
				this.animate(entity.animationState8, cursed_keeperAnimation.firethrowing, ageInTicks, 1f);
				this.animate(entity.animationState9, cursed_keeperAnimation.wind_shield, ageInTicks, 1f);
				this.animate(entity.animationState10, cursed_keeperAnimation.stalagmite_piercing, ageInTicks, 1f);
				this.animate(entity.animationState11, cursed_keeperAnimation.water_healing, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CursedKeeperEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
