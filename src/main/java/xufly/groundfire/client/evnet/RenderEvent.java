package xufly.groundfire.client.evnet;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import xufly.groundfire.GroundFire;

@Mod.EventBusSubscriber(modid = GroundFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderEvent
{
	@SubscribeEvent
	public static void render(FMLClientSetupEvent event)
	{
		event.enqueueWork(() ->
		{
			//EntityRenderersEvent
		});
	}
}
