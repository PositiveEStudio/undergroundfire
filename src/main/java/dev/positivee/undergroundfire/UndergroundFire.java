package dev.positivee.undergroundfire;

import com.mojang.logging.LogUtils;
import dev.positivee.undergroundfire.block.BlockRegistry;
import dev.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import dev.positivee.undergroundfire.creative.CreativeTabRegistry;
import dev.positivee.undergroundfire.data.DataGen;
import dev.positivee.undergroundfire.entity.EntityRegistry;
import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(UndergroundFire.MODID)
public class UndergroundFire
{
	public static final String MODID = "undergroundfire";
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

	public UndergroundFire()
	{
		MinecraftForge.EVENT_BUS.register(this);

		ItemRegistry.ITEMS.register(bus);
		BlockRegistry.BLOCKS.register(bus);
		BlockEntityRegistry.BLOCK_ENTITY_TYPE.register(bus);
		EntityRegistry.ENTITY_TYPE.register(bus);
		CreativeTabRegistry.CREATIVE_MODE_TAB.register(bus);
		bus.addListener(DataGen::gatherData);
	}
}
