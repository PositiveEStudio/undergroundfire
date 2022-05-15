package xufly.groundfire.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockBurningRichCoalOre extends Block
{
	public BlockBurningRichCoalOre()
	{
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE));
	}
}
