package xufly.groundfire.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockRichCoalOre extends Block
{
	public BlockRichCoalOre()
	{
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE));
	}

}
