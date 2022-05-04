package xufly.groundfire;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xufly.groundfire.item.ItemRegistryHandler;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GroundFire.MODID)
public class GroundFire
{
	public static final String MODID = "groundfire";
	private static final Logger LOGGER = LogUtils.getLogger();

	public GroundFire()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

		MinecraftForge.EVENT_BUS.register(this);

		ItemRegistryHandler.ITEM_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		// some preinit code
	}

	//dispatch IMC to another mod
	private void enqueueIMC(final InterModEnqueueEvent event)
	{
		// Some example code to
		InterModComms.sendTo("groundfire", "helloworld", () ->
		{
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	// receive and process InterModComms from other mods
	private void processIMC(final InterModProcessEvent event)
	{
		LOGGER.info("Got IMC {}", event.getIMCStream().map(m -> m.messageSupplier().get()).collect(Collectors.toList()));
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
