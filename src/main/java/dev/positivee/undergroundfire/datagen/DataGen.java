package dev.positivee.undergroundfire.datagen;

import dev.positivee.undergroundfire.UndergroundFire;
import dev.positivee.undergroundfire.datagen.blockstate.DataBlockStateProv;
import dev.positivee.undergroundfire.datagen.lang.DataLangProvENUS;
import dev.positivee.undergroundfire.datagen.lang.DataLangProvZHCN;
import dev.positivee.undergroundfire.datagen.model.DataBlockModelProv;
import dev.positivee.undergroundfire.datagen.model.DataItemModelProv;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DataGen
{
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeClient(), new DataLangProvZHCN(output, UndergroundFire.MODID));
		generator.addProvider(event.includeClient(), new DataLangProvENUS(output, UndergroundFire.MODID));

		generator.addProvider(event.includeClient(), new DataBlockModelProv(output, UndergroundFire.MODID, helper));
		generator.addProvider(event.includeClient(), new DataItemModelProv(output, UndergroundFire.MODID, helper));

		generator.addProvider(event.includeClient(), new DataBlockStateProv(output, UndergroundFire.MODID, helper));
	}
}
