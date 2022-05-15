package xufly.groundfire.render;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import xufly.groundfire.fluid.FluidRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderTypeRegistry
{
	@SubscribeEvent
	public static void onRenderTypeSetup(FMLClientSetupEvent event)
	{
		ItemBlockRenderTypes.setRenderLayer(FluidRegistry.coalGasSource.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(FluidRegistry.coalGasFlow.get(), RenderType.translucent());
	}
}
