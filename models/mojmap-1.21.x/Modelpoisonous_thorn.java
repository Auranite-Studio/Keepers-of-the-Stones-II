// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelpoisonous_thorn<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "poisonous_thorn"), "main");
	private final ModelPart bone;

	public Modelpoisonous_thorn(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-8.0F, -5.0F, 3.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-10.5F, -2.5F, 3.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -3.6F, 2.5F, 2.0F, 2.2F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 5)
						.addBox(-8.6F, -3.0F, 0.5F, 1.2F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 11.0F, -2.0F, -1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}