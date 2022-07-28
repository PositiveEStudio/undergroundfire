package xufly.groundfire.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import xufly.groundfire.block.BlockRegistry;
import xufly.groundfire.common.CheckBlock;

import java.util.Random;

public class BlockEntityRichCoalOre extends BlockEntity
{
	private int fireTime;

	public BlockEntityRichCoalOre(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.blockEntityRichCoalOre.get(), pos, state);
		Random random = new Random(pos.asLong());
		fireTime = random.nextInt(100, 200);
	}

	public static <T extends BlockEntity> void tick(Level world, BlockPos pos, BlockState State, BlockEntityRichCoalOre entity)
	{
		if (!world.isClientSide() && CheckBlock.CheckAroundFireBlock(world, pos))
		{
			if (entity.fireTime == 0)
				world.setBlock(pos, BlockRegistry.burningRichCoalOre.get().defaultBlockState(), 2);
			else
				entity.fireTime--;
		}
	}
}
