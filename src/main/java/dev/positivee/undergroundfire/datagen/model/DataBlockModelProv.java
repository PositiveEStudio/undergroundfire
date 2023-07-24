package dev.positivee.undergroundfire.datagen.model;

import dev.positivee.undergroundfire.UndergroundFire;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DataBlockModelProv extends BlockModelProvider
{

	public DataBlockModelProv(PackOutput output, String modid, ExistingFileHelper existingFileHelper)
	{
		super(output, modid, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		this.cubeAll("rich_coal_ore",
				new ResourceLocation(UndergroundFire.MODID, "block/rich_coal_ore"));
		this.cubeAll("burning_rich_coal_ore",
				new ResourceLocation(UndergroundFire.MODID, "block/burning_rich_coal_ore"));
		this.cube("coal_gas_extractor",
				new ResourceLocation(UndergroundFire.MODID, "block/test/down"),
				new ResourceLocation(UndergroundFire.MODID, "block/test/up"),
				new ResourceLocation(UndergroundFire.MODID, "block/test/north"),
				new ResourceLocation(UndergroundFire.MODID, "block/test/south"),
				new ResourceLocation(UndergroundFire.MODID, "block/test/east"),
				new ResourceLocation(UndergroundFire.MODID, "block/test/west"));

	}
}