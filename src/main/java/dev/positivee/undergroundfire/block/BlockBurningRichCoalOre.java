package dev.positivee.undergroundfire.block;

import dev.positivee.undergroundfire.block.entity.BlockEntityBurningRichCoalOre;
import dev.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class BlockBurningRichCoalOre extends BaseEntityBlock
{
	public static final BooleanProperty CAN_BURN_OUT = BooleanProperty.create("can_burn_out");
	public static final IntegerProperty OUTPUTS = IntegerProperty.create("outputs", 0, 10);

	public BlockBurningRichCoalOre()
	{
		super(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).ignitedByLava());
		this.registerDefaultState(this.getStateDefinition().any().setValue(CAN_BURN_OUT, true).setValue(OUTPUTS, 5));
	}

	@Override
	public RenderShape getRenderShape(BlockState pState)
	{
		return RenderShape.MODEL;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
	{
		pBuilder.add(CAN_BURN_OUT).add(OUTPUTS);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
	{
		return new BlockEntityBurningRichCoalOre(pPos, pState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType)
	{
		return pLevel.isClientSide ? null : createTickerHelper(pBlockEntityType, BlockEntityRegistry.BURNING_RICH_COAL_ORE.get(), BlockEntityBurningRichCoalOre::tick);
	}
}
