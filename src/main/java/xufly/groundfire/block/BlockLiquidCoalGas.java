package xufly.groundfire.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import xufly.groundfire.fluid.FluidRegistry;

public class BlockLiquidCoalGas extends LiquidBlock
{
	public BlockLiquidCoalGas()
	{
		super(FluidRegistry.coalGasSource, BlockBehaviour.Properties.of(Material.AIR).strength(100F).noDrops().sound(SoundType.STEM));
	}
}
