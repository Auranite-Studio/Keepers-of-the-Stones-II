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
public class Modelcursed_keeper<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelcursed_keeper"), "main");
	public final ModelPart ku_boss;
	public final ModelPart Body;
	public final ModelPart Head;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;
	public final ModelPart chain1;
	public final ModelPart chain2;
	public final ModelPart chain3;
	public final ModelPart monetka;

	public Modelcursed_keeper(ModelPart root) {
		this.ku_boss = root.getChild("ku_boss");
		this.Body = this.ku_boss.getChild("Body");
		this.Head = this.Body.getChild("Head");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightLeg = this.ku_boss.getChild("RightLeg");
		this.LeftLeg = this.ku_boss.getChild("LeftLeg");
		this.chain1 = this.ku_boss.getChild("chain1");
		this.chain2 = this.ku_boss.getChild("chain2");
		this.chain3 = this.ku_boss.getChild("chain3");
		this.monetka = this.ku_boss.getChild("monetka");
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
		PartDefinition chain1 = ku_boss.addOrReplaceChild("chain1",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 26.0F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, -28.0F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -16.0F, 0.0F));
		PartDefinition chain1_r1 = chain1.addOrReplaceChild("chain1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -26.5F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition chain1_r2 = chain1.addOrReplaceChild("chain1_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition chain1_r3 = chain1.addOrReplaceChild("chain1_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition chain1_r4 = chain1.addOrReplaceChild("chain1_r4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition chain1_r5 = chain1.addOrReplaceChild("chain1_r5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition chain1_r6 = chain1.addOrReplaceChild("chain1_r6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 27.5F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition chain2 = ku_boss.addOrReplaceChild("chain2",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 26.0F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, -28.0F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition chain2_r1 = chain2.addOrReplaceChild("chain2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -26.5F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition chain2_r2 = chain2.addOrReplaceChild("chain2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition chain2_r3 = chain2.addOrReplaceChild("chain2_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition chain2_r4 = chain2.addOrReplaceChild("chain2_r4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition chain2_r5 = chain2.addOrReplaceChild("chain2_r5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition chain2_r6 = chain2.addOrReplaceChild("chain2_r6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 27.5F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition chain3 = ku_boss.addOrReplaceChild("chain3",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 26.0F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.0F, -28.0F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.6155F, 0.5236F, -0.9553F));
		PartDefinition chain3_r1 = chain3.addOrReplaceChild("chain3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -26.5F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition chain3_r2 = chain3.addOrReplaceChild("chain3_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition chain3_r3 = chain3.addOrReplaceChild("chain3_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition chain3_r4 = chain3.addOrReplaceChild("chain3_r4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, 0.0F, -1.5708F, -1.5708F));
		PartDefinition chain3_r5 = chain3.addOrReplaceChild("chain3_r5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -27.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition chain3_r6 = chain3.addOrReplaceChild("chain3_r6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, -28.0F, 0.0F, 3.0F, 56.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 27.5F, 0.0F, 0.0F, 0.0F, -1.5708F));
		PartDefinition monetka = ku_boss.addOrReplaceChild("monetka",
				CubeListBuilder.create().texOffs(106, 116).addBox(-2.0F, -5.5F, -0.5F, 4.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(100, 106).addBox(-4.0F, -4.5F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(100, 118)
						.addBox(2.0F, -4.5F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(96, 108).addBox(-5.0F, -3.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(96, 120)
						.addBox(4.0F, -3.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(92, 110).addBox(-6.0F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(92, 122)
						.addBox(5.0F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -5.5F, -4.5F));
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