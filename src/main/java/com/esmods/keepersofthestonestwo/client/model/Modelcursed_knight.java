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
public class Modelcursed_knight<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelcursed_knight"), "main");
	public final ModelPart ricar_big;
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	public final ModelPart bone2;
	public final ModelPart left_leg;
	public final ModelPart right_leg;

	public Modelcursed_knight(ModelPart root) {
		this.ricar_big = root.getChild("ricar_big");
		this.body = this.ricar_big.getChild("body");
		this.head = this.body.getChild("head");
		this.left_arm = this.body.getChild("left_arm");
		this.right_arm = this.body.getChild("right_arm");
		this.bone2 = this.right_arm.getChild("bone2");
		this.left_leg = this.ricar_big.getChild("left_leg");
		this.right_leg = this.ricar_big.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition ricar_big = partdefinition.addOrReplaceChild("ricar_big", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition body = ricar_big.addOrReplaceChild("body", CubeListBuilder.create().texOffs(33, 32).addBox(-6.0F, -5.0F, -4.0F, 12.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(30, 22)
				.addBox(-6.0F, 0.0F, -4.0F, 12.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-7.0F, -15.0F, -5.0F, 14.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 1.0F));
		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(60, 44).addBox(5.0F, -9.0F, -2.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 24).addBox(7.0F, -11.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 19).addBox(-9.0F, -11.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(40, 24)
						.addBox(-9.0F, -9.0F, -2.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(30, 19).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -15.0F, -0.5F));
		PartDefinition left_arm = body.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(53, 59).addBox(-0.001F, -2.0F, -3.5F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(20, 44).addBox(0.0F, -1.0F, -2.5F, 5.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(7.0F, -14.0F, -0.5F));
		PartDefinition right_arm = body.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(59, 15).addBox(-5.999F, -2.0F, -3.5F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 39).addBox(-5.0F, -1.0F, -2.5F, 5.0F, 20.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.0F, -14.0F, -0.5F));
		PartDefinition bone2 = right_arm.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(8, 116).addBox(3.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 115).addBox(6.0F, -4.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 107)
						.addBox(1.0F, -5.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 122).addBox(2.0F, -9.0F, -1.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 125)
						.addBox(-2.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 123).addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 122)
						.addBox(13.0F, -16.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 112).addBox(-1.0F, -8.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 120)
						.addBox(2.0F, -4.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(52, 124).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 116)
						.addBox(0.0F, -9.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 123).addBox(6.0F, -13.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 124)
						.addBox(5.0F, -12.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125).addBox(4.0F, -11.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 118)
						.addBox(4.0F, -4.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 118).addBox(8.0F, -15.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 120)
						.addBox(11.0F, -16.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 118).addBox(9.0F, -16.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 121)
						.addBox(12.0F, -16.0F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 119).addBox(10.0F, -16.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 118)
						.addBox(7.0F, -14.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 17.0F, 2.5F, 1.5708F, 0.829F, 1.5708F));
		PartDefinition left_leg = ricar_big.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 44).addBox(-2.4571F, -0.8367F, -2.6946F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -4.0F, 1.0F));
		PartDefinition right_leg = ricar_big.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(46, 0).addBox(-2.6359F, -1.1383F, -1.6084F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		ricar_big.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}