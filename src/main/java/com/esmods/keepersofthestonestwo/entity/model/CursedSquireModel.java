package com.esmods.keepersofthestonestwo.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.entity.CursedSquireEntity;

public class CursedSquireModel extends GeoModel<CursedSquireEntity> {
	@Override
	public ResourceLocation getAnimationResource(CursedSquireEntity entity) {
		return ResourceLocation.parse("power:animations/cursed_squire.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CursedSquireEntity entity) {
		return ResourceLocation.parse("power:geo/cursed_squire.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CursedSquireEntity entity) {
		return ResourceLocation.parse("power:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(CursedSquireEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
