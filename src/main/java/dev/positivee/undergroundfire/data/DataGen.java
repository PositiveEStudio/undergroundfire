package dev.positivee.undergroundfire.data;

import dev.positivee.undergroundfire.UndergroundFire;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DataGen
{
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();

		generator.addProvider(event.includeClient(), new DataLangProvZHCN(output, UndergroundFire.MODID));
	}
}
