package com.esmods.keepersofthestonestwo.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.entity.SpiritEntity;

public class SpiritModel extends GeoModel<SpiritEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpiritEntity entity) {
		return new ResourceLocation("power", "animations/spirit.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpiritEntity entity) {
		return new ResourceLocation("power", "geo/spirit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpiritEntity entity) {
		return new ResourceLocation("power", "textures/entities/" + entity.getTexture() + ".png");
	}

}
