package xufly.groundfire.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;

public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GroundFire.MODID);

	public static final RegistryObject<LiquidBlock> coalGas = BLOCKS.register("coal_gas", BlockLiquidCoalGas::new);

	public static final RegistryObject<Block> richCoalOre = BLOCKS.register("rich_coal_ore", BlockRichCoalOre::new);
	public static final RegistryObject<Block> burningCoalOer = BLOCKS.register("burning_rich_coal_ore", BlockBurningRichCoalOre::new);
}