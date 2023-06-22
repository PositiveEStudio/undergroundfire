package com.mcxufly.positivee.undergroundfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class BlockGasTank extends Block
{
	private static VoxelShape shape;

	static
	{
		VoxelShape block1 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
		shape = Shapes.or(block1);
	}

	public BlockGasTank()
	{
		super(Properties.of(Material.METAL).sound(SoundType.ANVIL));
	}

	@NotNull
	@Override
	public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
	{
		return shape;
	}

	/*@NotNull
	@Override
	public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_)
	{
		if (!p_60504_.isClientSide() && p_60506_.getMainHandItem().getItem().equals(Items.FLINT_AND_STEEL))
		{
			p_60504_.explode(null, p_60505_.getX(), p_60505_.getY(), p_60505_.getZ(), 5, );
			return InteractionResult.SUCCESS;
		}
		else
		{
			return InteractionResult.FAIL;
		}
	}*/
}
