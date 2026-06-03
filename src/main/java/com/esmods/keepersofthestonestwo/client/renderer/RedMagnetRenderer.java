package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.esmods.keepersofthestonestwo.entity.RedMagnetEntity;
import com.esmods.keepersofthestonestwo.client.model.Modelmagnet;

public class RedMagnetRenderer extends MobRenderer<RedMagnetEntity, Modelmagnet<RedMagnetEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("power:textures/entities/magnet_red.png");

	public RedMagnetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmagnet<RedMagnetEntity>(context.bakeLayer(Modelmagnet.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(RedMagnetEntity entity) {
		return entityTexture;
	}
}