package dev.positivee.undergroundfire.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.positivee.undergroundfire.client.model.ModelMouse;
import dev.positivee.undergroundfire.entity.EntityMouse;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;

public class RendererMouse extends LivingEntityRenderer<EntityMouse, ModelMouse<EntityMouse>>
{

	public RendererMouse(EntityRendererProvider.Context pContext)
	{
		super(pContext, new ModelMouse(pContext.bakeLayer(ModelMouse.LAYER_LOCATION)),0.2F);
	}

	@Override
	public void render(EntityMouse pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight)
	{
		super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityMouse pEntity)
	{
		return new ResourceLocation("undergroundfire:textures/entity/mouse.png");
	}
}
