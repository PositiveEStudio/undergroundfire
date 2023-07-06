package dev.positivee.undergroundfire.common;

import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CheckBlock
{
	private static final Block[] canFire = new Block[]{Blocks.FIRE, Blocks.LAVA, Blocks.SOUL_FIRE, Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE, BlockRegistry.BURNING_RICH_COAL_ORE.get()};

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
		for (int x = -2; x <= 2; x++)
		{
			for (int y = -2; y <= 2; y++)
			{
				for (int z = -2; z <= 2; z++)
				{
					BlockPos checkPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
					if (world.getBlockState(checkPos).getBlock().equals(Blocks.WATER))
						return true;
				}
			}
		}
		return false;
	}
}
