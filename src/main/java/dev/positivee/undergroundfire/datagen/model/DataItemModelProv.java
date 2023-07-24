package dev.positivee.undergroundfire.datagen.model;

import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DataItemModelProv extends ItemModelProvider
{
	public DataItemModelProv(PackOutput output, String modid, ExistingFileHelper existingFileHelper)
	{
		super(output, modid, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		this.basicItem(ItemRegistry.MOUSE.get());
		this.basicItem(ItemRegistry.GAS_TANK.get());
	}
}
