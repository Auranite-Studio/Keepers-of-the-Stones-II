
package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.esmods.keepersofthestonestwo.entity.BlueMagnetEntity;
import com.esmods.keepersofthestonestwo.client.model.Modelmagnet;

public class BlueMagnetRenderer extends MobRenderer<BlueMagnetEntity, LivingEntityRenderState, Modelmagnet> {
	private BlueMagnetEntity entity = null;

	public BlueMagnetRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmagnet(context.bakeLayer(Modelmagnet.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(BlueMagnetEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("power:textures/entities/magnet_blue.png");
	}
}
