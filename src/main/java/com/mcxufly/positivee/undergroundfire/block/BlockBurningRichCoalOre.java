package com.mcxufly.positivee.undergroundfire.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class BlockBurningRichCoalOre extends Block
{
	public static final BooleanProperty BURN = BooleanProperty.create("can_burn_out");

	public BlockBurningRichCoalOre()
	{
		super(BlockBehaviour.Properties.of().strength(2.8F, 2.8F).requiresCorrectToolForDrops().sound(SoundType.STONE));
		this.registerDefaultState(this.getStateDefinition().any().setValue(BURN, true));
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_)
	{
		return RenderShape.MODEL;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder)
	{
		blockStateBuilder.add(BURN);
	}
}
