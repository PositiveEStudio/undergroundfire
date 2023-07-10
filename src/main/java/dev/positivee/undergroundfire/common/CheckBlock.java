package dev.positivee.undergroundfire.common;

import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;

public class CheckBlock
{
	public class RichCoalOreFuns
	{
		private static final Block[] canFire = new Block[]{Blocks.FIRE, Blocks.LAVA, Blocks.SOUL_FIRE, Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE, BlockRegistry.BURNING_RICH_COAL_ORE.get()};

		public static boolean CheckAroundFireBlock(Level world, BlockPos pos)
		{
			for (Block block : canFire)
			{
				if (world.getBlockState(pos.above()).getBlock().equals(block)) return true;
				if (world.getBlockState(pos.below()).getBlock().equals(block)) return true;
				if (world.getBlockState(pos.east()).getBlock().equals(block)) return true;
				if (world.getBlockState(pos.west()).getBlock().equals(block)) return true;
				if (world.getBlockState(pos.north()).getBlock().equals(block)) return true;
				if (world.getBlockState(pos.south()).getBlock().equals(block)) return true;
			}
			return false;
		}
	}

	public class GasCoalFuns
	{
		public static boolean CheckAirOrGasCoal(Level level, BlockPos pos, ArrayList<BlockPos> targetPos)
		{
			for (int i = -1; i < 1; i++)
			{
				for (int j = -1; j < 1; j++)
				{
					for (int k = -1; k < 1; k++)
					{
						BlockPos newPos = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
						Block block = level.getBlockState(newPos).getBlock();
						if (block.equals(Blocks.AIR) || block.equals(BlockRegistry.GAS_COAL.get()))
							targetPos.add(newPos);
					}
				}
			}
			return !targetPos.isEmpty();
		}
	}
}
