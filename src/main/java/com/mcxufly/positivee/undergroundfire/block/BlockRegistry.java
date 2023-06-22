package com.mcxufly.positivee.undergroundfire.block;

import com.mcxufly.positivee.undergroundfire.UndergroundFire;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UndergroundFire.MODID);

	public static final RegistryObject<Block> richCoalOre = BLOCKS.register("rich_coal_ore", BlockRichCoalOre::new);
	public static final RegistryObject<Block> burningRichCoalOre = BLOCKS.register("burning_rich_coal_ore", BlockBurningRichCoalOre::new);
	public static final RegistryObject<Block> gasTank = BLOCKS.register("gas_tank", BlockGasTank::new);
	public static final RegistryObject<Block> gasCoal = BLOCKS.register("gas_coal", BlockGasCoal::new);
}