package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.esmods.keepersofthestonestwo.entity.BlueMagnetEntity;
import com.esmods.keepersofthestonestwo.client.model.Modelmagnet;

public class BlueMagnetRenderer extends MobRenderer<BlueMagnetEntity, Modelmagnet<BlueMagnetEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("power:textures/entities/magnet_blue.png");

	public BlueMagnetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmagnet<BlueMagnetEntity>(context.bakeLayer(Modelmagnet.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlueMagnetEntity entity) {
		return entityTexture;
	}
}