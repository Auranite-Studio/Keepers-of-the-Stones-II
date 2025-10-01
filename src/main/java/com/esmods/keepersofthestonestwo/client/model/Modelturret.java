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
public class Modelturret<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelturret"), "main");
	public final ModelPart pushka;
	public final ModelPart bone;
	public final ModelPart bone2;
	public final ModelPart bone6;
	public final ModelPart bone5;
	public final ModelPart bone3;
	public final ModelPart leg1;
	public final ModelPart leg2;
	public final ModelPart leg3;
	public final ModelPart leg4;

	public Modelturret(ModelPart root) {
		this.pushka = root.getChild("pushka");
		this.bone = this.pushka.getChild("bone");
		this.bone2 = this.bone.getChild("bone2");
		this.bone6 = this.bone2.getChild("bone6");
		this.bone5 = this.bone6.getChild("bone5");
		this.bone3 = this.bone5.getChild("bone3");
		this.leg1 = this.pushka.getChild("leg1");
		this.leg2 = this.pushka.getChild("leg2");
		this.leg3 = this.pushka.getChild("leg3");
		this.leg4 = this.pushka.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition pushka = partdefinition.addOrReplaceChild("pushka", CubeListBuilder.create(), PartPose.offset(5.5F, 19.0F, 5.5F));
		PartDefinition bone = pushka.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 2.5F, -5.5F));
		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(64, 15).addBox(-3.5F, -2.0F, -1.5F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(55, 64)
				.addBox(-1.5F, -2.0F, -3.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(30, 21).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));
		PartDefinition bone6 = bone2.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition bone6_r1 = bone6.addOrReplaceChild("bone6_r1", CubeListBuilder.create().texOffs(42, 51).addBox(-3.0F, -14.0F, -3.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.0F, 0.5F, 0.0436F, 0.0F, 0.0F));
		PartDefinition bone5 = bone6.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(0, 21).addBox(-4.5F, -8.5F, -6.0F, 9.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, -6.0F, -9.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -8.25F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition bone3 = bone5.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(62, 54).addBox(-3.0F, -3.5F, -2.5F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -3.5F, -9.5F));
		PartDefinition leg1 = pushka.addOrReplaceChild("leg1",
				CubeListBuilder.create().texOffs(18, 51).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 60).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, -1.0F, -12.5F));
		PartDefinition leg2 = pushka.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(54, 32).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, -1.0F, 1.5F));
		PartDefinition leg3 = pushka.addOrReplaceChild("leg3",
				CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(57, 45).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-12.0F, -1.0F, -12.5F));
		PartDefinition leg4 = pushka.addOrReplaceChild("leg4",
				CubeListBuilder.create().texOffs(36, 36).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(57, 21).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-12.0F, -1.0F, 1.5F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		pushka.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}