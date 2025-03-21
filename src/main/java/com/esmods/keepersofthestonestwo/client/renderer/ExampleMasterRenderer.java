
package com.esmods.keepersofthestonestwo.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import com.esmods.keepersofthestonestwo.entity.ExampleMasterEntity;

public class ExampleMasterRenderer extends HumanoidMobRenderer<ExampleMasterEntity, HumanoidModel<ExampleMasterEntity>> {
	public ExampleMasterRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<ExampleMasterEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(ExampleMasterEntity entity) {
		return ResourceLocation.parse("power:textures/entities/steve.png");
	}
}
