package com.esmods.keepersofthestonestwo.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcursed_keeper_without_chains<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelcursed_keeper_without_chains"), "main");
	public final ModelPart ku_boss;
	public final ModelPart Body;
	public final ModelPart Head;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;

	public Modelcursed_keeper_without_chains(ModelPart root) {
		this.ku_boss = root.getChild("ku_boss");
		this.Body = this.ku_boss.getChild("Body");
		this.Head = this.Body.getChild("Head");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightLeg = this.ku_boss.getChild("RightLeg");
		this.LeftLeg = this.ku_boss.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition ku_boss = partdefinition.addOrReplaceChild("ku_boss", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Body = ku_boss
				.addOrReplaceChild(
						"Body", CubeListBuilder.create().texOffs(52, 19).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(28, 28).addBox(-5.0F, -10.0F, -2.0F, 10.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
								.texOffs(28, 12).addBox(-5.0F, -10.0F, -2.0F, 10.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)).texOffs(24, 0).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)),
						PartPose.offset(0.0F, -15.0F, 0.0F));
		PartDefinition Head = Body.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, -9.0F, 0.0F));
		PartDefinition RightArm = Body.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(28, 59).addBox(-3.0F, -3.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 59).addBox(-3.0F, -3.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-5.0F, -7.0F, 0.0F));
		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -3.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 39).addBox(0.0F, -3.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(5.0F, -7.0F, 0.0F));
		PartDefinition RightLeg = ku_boss.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(56, 0).addBox(-2.1F, -3.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(52, 35).addBox(-2.1F, -3.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(-1.9F, -12.0F, 0.0F));
		PartDefinition LeftLeg = ku_boss.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(16, 35).addBox(-1.9F, -3.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 32).addBox(-1.9F, -3.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(1.9F, -12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		ku_boss.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}
