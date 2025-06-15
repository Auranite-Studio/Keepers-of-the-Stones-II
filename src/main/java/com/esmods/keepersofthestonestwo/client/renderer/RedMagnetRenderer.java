package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.esmods.keepersofthestonestwo.entity.RedMagnetEntity;
import com.esmods.keepersofthestonestwo.client.model.Modelmagnet;

public class RedMagnetRenderer extends MobRenderer<RedMagnetEntity, LivingEntityRenderState, Modelmagnet> {
	private RedMagnetEntity entity = null;

	public RedMagnetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmagnet(context.bakeLayer(Modelmagnet.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(RedMagnetEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/magnet_red.png");
	}
}