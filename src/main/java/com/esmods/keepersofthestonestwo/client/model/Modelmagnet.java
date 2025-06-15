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

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelmagnet extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelmagnet"), "main");
	public final ModelPart group;

	public Modelmagnet(ModelPart root) {
		super(root);
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition group = partdefinition.addOrReplaceChild("group", CubeListBuilder.create().texOffs(10, 12).addBox(-12.0F, -5.0F, -2.0F, 12.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 23)
				.addBox(-12.0F, -16.0F, -2.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(-5.0F, -16.0F, -2.0F, 5.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 24.0F, -1.0F));
		return LayerDefinition.create(meshdefinition, 48, 48);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}
}