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

public class ModelMouse extends EntityModel<EntityMouse>
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

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition back_r1 = head.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 1.75F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(-1.0F, 6.75F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.75F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition link = head.addOrReplaceChild("link", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition link3_r1 = link.addOrReplaceChild("link3_r1", CubeListBuilder.create().texOffs(22, 0).addBox(-2.0F, 5.75F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(1.0F, 5.75F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(18, 0).addBox(-1.0F, 5.75F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 0).addBox(-1.0F, 5.75F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 12.5F, 0.0F));

		PartDefinition back_r2 = body.addOrReplaceChild("back_r2", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -3.25F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.25F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition side0 = body.addOrReplaceChild("side0", CubeListBuilder.create(), PartPose.offset(0.0F, 11.5F, 0.0F));

		PartDefinition s2_r1 = side0.addOrReplaceChild("s2_r1", CubeListBuilder.create().texOffs(26, 3).addBox(-1.0F, -2.25F, -2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 3).addBox(-1.0F, -2.25F, 1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition side1 = body.addOrReplaceChild("side1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition s2_r2 = side1.addOrReplaceChild("s2_r2", CubeListBuilder.create().texOffs(26, 3).addBox(-1.0F, 3.75F, -2.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 3).addBox(-1.0F, 3.75F, 1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition link_r1 = tail.addOrReplaceChild("link_r1", CubeListBuilder.create().texOffs(18, 5).addBox(-0.5F, -7.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 4).addBox(-1.0F, -5.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition back = tail.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition blade3_r1 = back.addOrReplaceChild("blade3_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-4.2753F, -7.0239F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, 1.5708F, 1.1345F, -1.5708F));

		PartDefinition blade2_r1 = back.addOrReplaceChild("blade2_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-4.2753F, -7.0239F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, -3.1416F, 0.0F, -0.4363F));

		PartDefinition blade1_r1 = back.addOrReplaceChild("blade1_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-4.2753F, -7.0239F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, -1.5708F, -1.1345F, -1.5708F));

		PartDefinition blade0_r1 = back.addOrReplaceChild("blade0_r1", CubeListBuilder.create().texOffs(-6, 12).addBox(-4.2753F, -7.0239F, 1.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, 0.0F, 0.0F, -2.7053F));

		PartDefinition knot_r1 = back.addOrReplaceChild("knot_r1", CubeListBuilder.create().texOffs(17, 4).addBox(-1.0F, -8.25F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.75F, 0.0F, 0.0F, 0.0F, -3.1416F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(EntityMouse entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
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