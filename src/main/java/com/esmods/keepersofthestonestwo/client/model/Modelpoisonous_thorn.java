package com.esmods.keepersofthestonestwo.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelpoisonous_thorn extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelpoisonous_thorn"), "main");
	public final ModelPart bone;

	public Modelpoisonous_thorn(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -5.0F, 3.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-10.5F, -2.5F, 3.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -3.6F, 2.5F, 2.0F, 2.2F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 5).addBox(-8.6F, -3.0F, 0.5F, 1.2F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 11.0F, -2.0F, -1.5708F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}
}