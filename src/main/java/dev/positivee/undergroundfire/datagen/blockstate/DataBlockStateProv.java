package dev.positivee.undergroundfire.datagen.blockstate;

import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DataBlockStateProv extends BlockStateProvider
{
	public DataBlockStateProv(PackOutput output, String modid, ExistingFileHelper exFileHelper)
	{
		super(output, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels()
	{
		this.simpleBlock(BlockRegistry.RICH_COAL_ORE.get());
		this.simpleBlock(BlockRegistry.BURNING_RICH_COAL_ORE.get());
//		this.simpleBlock(BlockRegistry.GAS_COAL_EXTRACTOR.get());
//		this.simpleBlock(BlockRegistry.GAS_TANK.get());
	}
}
