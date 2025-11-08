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
public class Modelenergium_golem<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("power", "modelenergium_golem"), "main");
	public final ModelPart boss;
	public final ModelPart body;
	public final ModelPart hand1;
	public final ModelPart hand2;
	public final ModelPart head;
	public final ModelPart leg1;
	public final ModelPart leg2;

	public Modelenergium_golem(ModelPart root) {
		this.boss = root.getChild("boss");
		this.body = this.boss.getChild("body");
		this.hand1 = this.body.getChild("hand1");
		this.hand2 = this.body.getChild("hand2");
		this.head = this.body.getChild("head");
		this.leg1 = this.boss.getChild("leg1");
		this.leg2 = this.boss.getChild("leg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition boss = partdefinition.addOrReplaceChild("boss", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body = boss.addOrReplaceChild("body", CubeListBuilder.create().texOffs(64, 0).addBox(-12.0F, -32.0F, -10.0F, 24.0F, 19.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(96, 96)
				.addBox(-10.0F, -13.0F, -8.0F, 20.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(48, 0).addBox(-5.0F, -28.0F, -11.0F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 0.0F));
		PartDefinition hand1 = body.addOrReplaceChild("hand1", CubeListBuilder.create().texOffs(48, 48).addBox(-4.0F, -3.0F, -8.0F, 16.0F, 48.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, -27.0F, 0.0F));
		PartDefinition hand2 = body.addOrReplaceChild("hand2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -3.0F, -8.0F, 16.0F, 48.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -27.0F, 0.0F));
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 98).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -32.0F, 0.0F));
		PartDefinition leg1 = boss.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 64).addBox(-6.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -16.0F, 0.0F));
		PartDefinition leg2 = boss.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(96, 39).addBox(-2.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -16.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		boss.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}