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
public class Modelatomic_rocket extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelatomic_rocket"), "main");
	public final ModelPart bone;

	public Modelatomic_rocket(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -18.0F, -1.0F, 16.0F, 18.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(-13.0F, -1.0F, 1.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 34)
						.addBox(-13.0F, -32.0F, 1.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(64, 26).addBox(-9.0F, -43.0F, 15.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 14)
						.addBox(-9.0F, -43.0F, -5.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-21.0F, -43.0F, 5.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 60)
						.addBox(3.0F, -43.0F, 5.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 60).addBox(-9.0F, -38.0F, 13.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(-9.0F, -38.0F, -3.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 34).addBox(-17.0F, -38.0F, 5.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 51)
						.addBox(-1.0F, -38.0F, 5.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -19.0F, -7.0F, 0.0F, 0.0F, -3.1416F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}
}