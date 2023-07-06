package dev.positivee.undergroundfire.block;

import dev.positivee.undergroundfire.UndergroundFire;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UndergroundFire.MODID);

	public static final RegistryObject<Block> RICH_COAL_ORE = BLOCKS.register("rich_coal_ore", BlockRichCoalOre::new);
	public static final RegistryObject<Block> BURNING_RICH_COAL_ORE = BLOCKS.register("burning_rich_coal_ore", BlockBurningRichCoalOre::new);
	public static final RegistryObject<Block> GAS_TANK = BLOCKS.register("gas_tank", BlockGasTank::new);
	public static final RegistryObject<Block> GAS_COAL = BLOCKS.register("gas_coal", BlockGasCoal::new);
}