package dev.positivee.undergroundfire.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityGasCoal extends BlockEntity
{
	public BlockEntityGasCoal(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.GAS_COAL.get(), pos, state);
	}

	public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityGasCoal blockEntity)
	{
		if (!level.isClientSide)
			level.setBlock(pos.above(), Blocks.GLASS.defaultBlockState(), 2);
	}
}
