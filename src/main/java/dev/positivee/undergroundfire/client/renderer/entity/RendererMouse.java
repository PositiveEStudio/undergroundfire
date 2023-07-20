package dev.positivee.undergroundfire.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.positivee.undergroundfire.entity.EntityMouse;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RendererMouse extends EntityRenderer<EntityMouse>
{

	public RendererMouse(EntityRendererProvider.Context pContext)
	{
		super(pContext);
		this.shadowRadius = 0.5F;
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
