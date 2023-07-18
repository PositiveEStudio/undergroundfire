package dev.positivee.undergroundfire.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class RendererMouse extends EntityRenderer
{

	public RendererMouse(EntityRendererProvider.Context pContext)
	{
		super(pContext);
	}

	@Override
	public ResourceLocation getTextureLocation(Entity pEntity)
	{
		return null;
	}
}
