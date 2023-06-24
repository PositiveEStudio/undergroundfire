package com.mcxufly.positivee.undergroundfire.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class BlockGasCoal extends Block
{
	public BlockGasCoal()
	{
		super(BlockBehaviour.Properties.of().noCollission());
	}

	@Override
	public RenderShape getRenderShape(BlockState pState)
	{
		return RenderShape.INVISIBLE;
	}

	/*@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit)
	{
		if (!pLevel.isClientSide() && pPlayer.getMainHandItem().getItem().equals(Items.FLINT_AND_STEEL))
		{
			pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 3, Explosion.BlockInteraction.DESTROY);
			return InteractionResult.SUCCESS;
		}
		else
		{
			return InteractionResult.FAIL;
		}
	}*/
}
