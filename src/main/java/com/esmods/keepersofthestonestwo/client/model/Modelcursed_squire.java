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
public class Modelcursed_squire extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelcursed_squire"), "main");
	public final ModelPart bone;
	public final ModelPart bone8;
	public final ModelPart bone4;
	public final ModelPart bone5;
	public final ModelPart bone3;
	public final ModelPart bone2;
	public final ModelPart bone7;
	public final ModelPart bone6;

	public Modelcursed_squire(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
		this.bone8 = this.bone.getChild("bone8");
		this.bone4 = this.bone8.getChild("bone4");
		this.bone5 = this.bone8.getChild("bone5");
		this.bone3 = this.bone8.getChild("bone3");
		this.bone2 = this.bone3.getChild("bone2");
		this.bone7 = this.bone.getChild("bone7");
		this.bone6 = this.bone.getChild("bone6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));
		PartDefinition bone8 = bone.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(21, 16).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(22, 23)
				.addBox(-3.5F, -2.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-4.0F, -8.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 1.0F));
		PartDefinition bone4 = bone8.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(12, 27).addBox(-0.5F, -2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -6.0F, 0.0F));
		PartDefinition bone5 = bone8.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-6.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 0)
						.addBox(-1.0F, -10.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(4.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition bone3 = bone8.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 27).addBox(-2.5F, -2.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -6.0F, -0.5F));
		PartDefinition bone2 = bone3.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(56, 61).addBox(-2.0607F, -0.2322F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 60).addBox(-1.0607F, -1.2322F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 57)
						.addBox(-0.0607F, -5.2322F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 58).addBox(0.9393F, -5.2322F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 55)
						.addBox(1.9393F, -6.2322F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 54).addBox(2.9393F, -7.2322F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 54)
						.addBox(3.9393F, -8.2322F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 56).addBox(4.9393F, -9.2322F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 56)
						.addBox(5.9393F, -10.2322F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 56).addBox(6.9393F, -11.2322F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 57)
						.addBox(7.9393F, -11.2322F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 58).addBox(8.9393F, -11.2322F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 59)
						.addBox(9.9393F, -11.2322F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(52, 61).addBox(-2.0607F, -4.2322F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 60)
						.addBox(-1.0607F, -5.2322F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 6.5F, 0.5F, 1.5708F, 0.7854F, 1.5708F));
		PartDefinition bone7 = bone.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -9.0F, 1.0F));
		PartDefinition bone6 = bone.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(24, 29).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -9.0F, 1.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}

}
