package dev.positivee.undergroundfire.client.renderer;

import dev.positivee.undergroundfire.UndergroundFire;
import dev.positivee.undergroundfire.client.model.ModelMouse;
import dev.positivee.undergroundfire.client.renderer.entity.RendererMouse;
import dev.positivee.undergroundfire.entity.EntityRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UndergroundFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RendererRegistry
{
	@SubscribeEvent
	public static void renderRegistry(EntityRenderersEvent.RegisterRenderers event)
	{
		event.registerEntityRenderer(EntityRegistry.MOUSE.get(), RendererMouse::new);
	}

	@SubscribeEvent
	public static void layerDefinitionsRegistry(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(ModelMouse.LAYER_LOCATION, ModelMouse::createBodyLayer);
	}
}
