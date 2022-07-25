package xufly.groundfire.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class BlockEntityBurningRichCoalOre extends BlockEntity
{
	private static int burnTime;

	public BlockEntityBurningRichCoalOre(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.entityBlockBurningRichCoal.get(), pos, state);
		Random random = new Random(pos.hashCode());
		burnTime = random.nextInt(550, 650);
	}

	public static <T extends BlockEntity> void tick(Level world, BlockPos pos, BlockState State, T t)
	{
		/*if (burnTime == 0)
		{
			if (CheckBlock.CheckAroundWater(world, pos))
				world.setBlock(pos, BlockRegistry.gasCoal.get().defaultBlockState(), 2);
			else
				world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
		}
		else
			burnTime--;*/
	}
}
