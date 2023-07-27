package dev.positivee.undergroundfire.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.positivee.undergroundfire.client.model.ModelMouse;
import dev.positivee.undergroundfire.entity.EntityMouse;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RendererMouse<T extends EntityMouse> extends EntityRenderer<T>
{
	private static final ResourceLocation MOUSE_LOCATION = new ResourceLocation("undergroundfire:textures/entity/mouse.png");
	protected final EntityModel<T> model;

	public RendererMouse(EntityRendererProvider.Context pContext)
	{
		super(pContext);
		this.shadowRadius = 0.2F;
		this.model = new ModelMouse<>(pContext.bakeLayer(ModelMouse.LAYER_LOCATION));
	}

	@Override
	public void render(T pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight)
	{
		super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);

	}

	@Override
	public ResourceLocation getTextureLocation(EntityMouse pEntity)
	{
		return MOUSE_LOCATION;
	}
}
