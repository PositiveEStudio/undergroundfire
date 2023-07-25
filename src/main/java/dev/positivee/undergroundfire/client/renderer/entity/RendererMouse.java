package dev.positivee.undergroundfire.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.positivee.undergroundfire.client.model.ModelMouse;
import dev.positivee.undergroundfire.entity.EntityMouse;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RendererMouse extends EntityRenderer<EntityMouse>
{
	private static final ResourceLocation MOUSE_LOCATION = new ResourceLocation("texture/entity/mouse.png");
	private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(MOUSE_LOCATION);

	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tail;

	public RendererMouse(EntityRendererProvider.Context pContext)
	{
		super(pContext);
		this.shadowRadius = 0.2F;

		ModelPart modelPart = pContext.bakeLayer(ModelMouse.LAYER_LOCATION);
		this.head = modelPart.getChild("head");
		this.body = modelPart.getChild("body");
		this.tail = modelPart.getChild("tail");
	}

	@Override
	public void render(EntityMouse pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight)
	{
//		pPoseStack.pushPose();
//		int i = OverlayTexture.NO_OVERLAY;
//		VertexConsumer vertexconsumer = pBuffer.getBuffer(RENDER_TYPE);
//		pPoseStack.pushPose();
//
//		this.tail.render(pPoseStack, vertexconsumer, pPackedLight, i);
//		pPoseStack.pushPose();
//		this.body.render(pPoseStack, vertexconsumer, pPackedLight, i);
//		pPoseStack.pushPose();
//		this.head.render(pPoseStack, vertexconsumer, pPackedLight, i);
//		pPoseStack.pushPose();

		super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityMouse pEntity)
	{
		return new ResourceLocation("undergroundfire:textures/entity/mouse.png");
	}
}
