package com.mcxufly.positivee.undergroundfire.client.evnet;

import com.mcxufly.positivee.undergroundfire.UndergroundFire;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = UndergroundFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
