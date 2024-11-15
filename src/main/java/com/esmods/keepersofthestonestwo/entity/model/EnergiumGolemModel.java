package com.esmods.keepersofthestonestwo.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.entity.EnergiumGolemEntity;

public class EnergiumGolemModel extends GeoModel<EnergiumGolemEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnergiumGolemEntity entity) {
		return ResourceLocation.parse("power:animations/energium_golem.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnergiumGolemEntity entity) {
		return ResourceLocation.parse("power:geo/energium_golem.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnergiumGolemEntity entity) {
		return ResourceLocation.parse("power:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(EnergiumGolemEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
