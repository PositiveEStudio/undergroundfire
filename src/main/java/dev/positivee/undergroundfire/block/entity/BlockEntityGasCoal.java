package dev.positivee.undergroundfire.block.entity;

import dev.positivee.undergroundfire.block.BlockGasCoal;
import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Random;

public class BlockEntityGasCoal extends BlockEntity
{
	protected boolean delay = true;

	public BlockEntityGasCoal(BlockPos pPos, BlockState pBlockState)
	{
		super(BlockEntityRegistry.GAS_COAL.get(), pPos, pBlockState);
	}

	public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityGasCoal blockEntity)
	{//TODO:继续改写 tick 方法直至有正常的扩散效果
		ArrayList<BlockPos> targetPos = new ArrayList<>();
		int airCount = 0;
		int concentration = blockEntity.getBlockState().getValue(BlockGasCoal.CONCENTRATION);

		if (blockEntity.delay)
		{
			blockEntity.delay = false;
			return;
		}

		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				for (int k = -1; k <= 1; k++)
				{
					if (i == 0 && j == 0 && k == 0) continue;

					BlockPos newPos = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
					Block block = level.getBlockState(newPos).getBlock();
					if (block.equals(Blocks.AIR) || block.equals(BlockRegistry.GAS_COAL.get()))
					{
						targetPos.add(newPos);
//						if (level.isClientSide)
//							level.addParticle(DustParticleOptions.REDSTONE, true, newPos.getX(), newPos.getY(), newPos.getZ(), 0.0D, 0.0D, 0.0D);
					}
				}
			}
		}

		for (int i = 0; i < targetPos.size() - 1; i++)
			airCount++;

		if (!targetPos.isEmpty())
		{
			Random random = new Random(pos.asLong() + state.getSeed(pos));
			int index;

			if (targetPos.size() == 1)
				index = 0;
			else
				index = random.nextInt(0, targetPos.size() - 1);

			BlockState targetState = level.getBlockState(targetPos.get(index));
			Block targetBlock = targetState.getBlock();

			if (!level.isClientSide)
			{
				if (airCount >= 20 && concentration <= 1)
				{
					level.removeBlock(pos, false);
				}
				else
				{
					if (targetBlock.equals(Blocks.AIR) && concentration > airCount * 0.8)
					{
						level.setBlock(targetPos.get(index), BlockRegistry.GAS_COAL.get().defaultBlockState().setValue(BlockGasCoal.CONCENTRATION, 1), 2);
						level.setBlock(pos, blockEntity.getBlockState().setValue(BlockGasCoal.CONCENTRATION, concentration - 1), 2);
					}

					if (targetBlock.equals(BlockRegistry.GAS_COAL.get()) && concentration - targetState.getValue(BlockGasCoal.CONCENTRATION) > 1)
					{
						level.setBlock(targetPos.get(index), targetState.setValue(BlockGasCoal.CONCENTRATION, targetState.getValue(BlockGasCoal.CONCENTRATION) + 1), 2);
						level.getBlockEntity(targetPos.get(index), BlockEntityRegistry.GAS_COAL.get()).get().isDelay();
						level.setBlock(pos, blockEntity.getBlockState().setValue(BlockGasCoal.CONCENTRATION, concentration - 1), 2);
					}
				}
			}
		}
	}

	public void isDelay()
	{
		this.delay = true;
	}
}
