package com.esmods.keepersofthestonestwo.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.entity.CursedKnightEntity;

public class CursedKnightModel extends GeoModel<CursedKnightEntity> {
	@Override
	public ResourceLocation getAnimationResource(CursedKnightEntity entity) {
		return ResourceLocation.parse("power:animations/cursed_knight.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CursedKnightEntity entity) {
		return ResourceLocation.parse("power:geo/cursed_knight.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CursedKnightEntity entity) {
		return ResourceLocation.parse("power:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(CursedKnightEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
