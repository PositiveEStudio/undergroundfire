package dev.positivee.undergroundfire.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.positivee.undergroundfire.client.model.ModelMouse;
import dev.positivee.undergroundfire.entity.EntityMouse;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RendererMouse extends EntityRenderer<EntityMouse>
{
	private static final ResourceLocation MOUSE_LOCATION = new ResourceLocation("undergroundfire:textures/entity/mouse.png");
	protected final ModelMouse model;

	public RendererMouse(EntityRendererProvider.Context pContext)
	{
		super(pContext);
		this.shadowRadius = 0.2F;
		this.model = new ModelMouse(pContext.bakeLayer(ModelMouse.LAYER_LOCATION));
	}

	@Override
	public void render(EntityMouse entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
	{
		// 根据材质生成什么 consumer，可理解为绑定材质
		VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(MOUSE_LOCATION));
		// 调用模型的相关方法
		this.model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		// 也可以这么写
//		this.model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutoutNoCull(MOUSE_LOCATION)), packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityMouse entity)
	{
		return MOUSE_LOCATION;
	}
}
