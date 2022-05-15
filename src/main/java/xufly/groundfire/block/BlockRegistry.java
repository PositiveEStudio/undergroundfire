package xufly.groundfire.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;
import xufly.groundfire.fluid.FluidRegistry;

public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GroundFire.MODID);

	public static final RegistryObject<LiquidBlock> coalGas = BLOCKS.register("coal_gas", () -> new LiquidBlock(FluidRegistry.coalGasSource, BlockBehaviour.Properties.of(Material.AIR, MaterialColor.NONE).strength(100F)));

	public static final RegistryObject<Block> richCoalOre = BLOCKS.register("rich_coal_ore", BlockRichCoalOre::new);
	public static final RegistryObject<Block> burningCoalOer = BLOCKS.register("burning_rich_coal_ore", BlockBurningRichCoalOre::new);
}