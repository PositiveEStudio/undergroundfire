package xufly.groundfire.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import xufly.groundfire.block.BlockRegistry;

public class CheckBlock
{
	private static final Block[] canFire = new Block[]{Blocks.FIRE, Blocks.LAVA, Blocks.SOUL_FIRE, Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE, BlockRegistry.burningCoalOre.get()};

	public static boolean CheckAroundFireBlock(Level world, BlockPos pos)
	{
		for (Block block : canFire)
		{
			if (world.getBlockState(pos.above()).getBlock().equals(block))
				return true;
			if (world.getBlockState(pos.below()).getBlock().equals(block))
				return true;
			if (world.getBlockState(pos.east()).getBlock().equals(block))
				return true;
			if (world.getBlockState(pos.west()).getBlock().equals(block))
				return true;
			if (world.getBlockState(pos.north()).getBlock().equals(block))
				return true;
			if (world.getBlockState(pos.south()).getBlock().equals(block))
				return true;
		}
		return false;
	}

	public static boolean CheckAroundWater(Level world, BlockPos pos)
	{
		int[][] dxys = new int[][]{{2, 2}, {1, 2}, {0, 2}, {2, 1}, {1, 1}, {1, 0}, {2, 0}, {1, 0}, {0, 0}};

		for (int[] dxy : dxys)
		{
			for (int dz = -2; dz <= 2; dz++)
			{
				if (world.getBlockState(pos.north(dxy[0]).west(dxy[1])).getBlock().equals(Blocks.WATER))
					return true;
				if (world.getBlockState(pos.north(dxy[0]).east(dxy[1])).getBlock().equals(Blocks.WATER))
					return true;
				if (world.getBlockState(pos.south(dxy[0]).west(dxy[1])).getBlock().equals(Blocks.WATER))
					return true;
				if (world.getBlockState(pos.south(dxy[0]).east(dxy[1])).getBlock().equals(Blocks.WATER))
					return true;
			}
		}
		return false;
	}
}
