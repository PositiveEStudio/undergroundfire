package com.mcxufly.positivee.undergroundfire.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import com.mcxufly.positivee.undergroundfire.block.BlockRegistry;
import com.mcxufly.positivee.undergroundfire.common.CheckBlock;

import java.util.Random;

public class BlockEntityBurningRichCoalOre extends BlockEntity
{
	private int burnTime;

	public BlockEntityBurningRichCoalOre(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.blockEntityBurningRichCoal.get(), pos, state);
		Random random = new Random(pos.hashCode());
		burnTime = random.nextInt(600, 900);
	}

	public static <T extends BlockEntity> void tick(Level world, BlockPos pos, BlockState State, BlockEntityBurningRichCoalOre entity)
	{
		if (entity.burnTime == 0)
		{
			if (CheckBlock.CheckAroundWater(world, pos))
				world.setBlock(pos, BlockRegistry.gasCoal.get().defaultBlockState(), 2);
			else
				world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
		}
		else
			entity.burnTime--;
	}
}
