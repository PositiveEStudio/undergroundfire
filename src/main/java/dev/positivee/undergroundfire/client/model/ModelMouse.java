package dev.positivee.undergroundfire.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.positivee.undergroundfire.UndergroundFire;
import dev.positivee.undergroundfire.entity.EntityMouse;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ModelMouse<T extends EntityMouse> extends EntityModel<T>
{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(UndergroundFire.MODID, "mouse"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tail;

	public ModelMouse(ModelPart root)
	{
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition link = head.addOrReplaceChild("link", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -3.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 0).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-2.0F, -3.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -12.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition side0 = body.addOrReplaceChild("side0", CubeListBuilder.create().texOffs(26, 3).addBox(-1.0F, -11.0F, 1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 3).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition side1 = body.addOrReplaceChild("side1", CubeListBuilder.create().texOffs(26, 3).addBox(-1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 3).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(17, 4).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(18, 5).addBox(-0.5F, -16.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition back = tail.addOrReplaceChild("back", CubeListBuilder.create().texOffs(17, 4).addBox(-1.0F, -17.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition blade3_r1 = back.addOrReplaceChild("blade3_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5F, 0.0F, 1.5708F, 1.1345F, 1.5708F));

		PartDefinition blade2_r1 = back.addOrReplaceChild("blade2_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5F, 0.0F, 0.0F, 3.1416F, -0.4363F));

		PartDefinition blade1_r1 = back.addOrReplaceChild("blade1_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5F, 0.0F, -1.5708F, -1.1345F, 1.5708F));

		PartDefinition blade0_r1 = back.addOrReplaceChild("blade0_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5F, 0.0F, 0.0F, 0.0F, 0.4363F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}