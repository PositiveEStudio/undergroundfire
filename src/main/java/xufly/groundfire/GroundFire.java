package xufly.groundfire;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import xufly.groundfire.block.BlockRegistry;
import xufly.groundfire.block.entity.BlockEntityRegistry;
import xufly.groundfire.client.gui.menu.MenuRegistry;
import xufly.groundfire.client.gui.screen.ScreenRegistry;
import xufly.groundfire.item.ItemRegistry;

@Mod(GroundFire.MODID)
public class GroundFire
{
	public static final String MODID = "groundfire";
	private static final Logger LOGGER = LogUtils.getLogger();

	public GroundFire()
	{


		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		bus.addListener(this::clientSetup);

		MinecraftForge.EVENT_BUS.register(this);

		ItemRegistry.ITEMS.register(bus);
		BlockRegistry.BLOCKS.register(bus);
		BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
		MenuRegistry.MENU.register(bus);
	}

	public void clientSetup(FMLClientSetupEvent event)
	{
		ScreenRegistry.register();
	}

	private void setup(final FMLCommonSetupEvent event)
	{
	}
}
