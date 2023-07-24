package dev.positivee.undergroundfire.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityGasCoalExacter extends BlockEntity
{
	public BlockEntityGasCoalExacter(BlockPos pPos, BlockState pBlockState)
	{
		super(BlockEntityRegistry.GAS_COAL_EXACTER.get(), pPos, pBlockState);
	}
}
