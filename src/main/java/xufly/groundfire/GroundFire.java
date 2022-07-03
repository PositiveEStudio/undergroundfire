package xufly.groundfire;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xufly.groundfire.block.BlockRegistry;
import xufly.groundfire.item.ItemRegistry;

@Mod(GroundFire.MODID)
public class GroundFire
{
	public static final String MODID = "groundfire";
	private static final Logger LOGGER = LogUtils.getLogger();

	public GroundFire()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

		MinecraftForge.EVENT_BUS.register(this);

		ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private void setup(final FMLCommonSetupEvent event)
	{
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event)
	{
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
		{
		}
	}
}
