package dev.positivee.undergroundfire.block;

import dev.positivee.undergroundfire.block.entity.BlockEntityGasCoal;
import dev.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BlockGasCoal extends BaseEntityBlock
{
	public static final IntegerProperty CONCENTRATION = IntegerProperty.create("concentration", 0, 1000);

	public BlockGasCoal()
	{
		super(Properties.copy(Blocks.AIR));
		this.registerDefaultState(this.getStateDefinition().any().setValue(CONCENTRATION, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
	{
		pBuilder.add(CONCENTRATION);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState)
	{
		return RenderShape.INVISIBLE;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
	{
		return Shapes.empty();
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
	{
		return new BlockEntityGasCoal(pPos, pState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType)
	{
		return pLevel.isClientSide ? null : createTickerHelper(pBlockEntityType, BlockEntityRegistry.GAS_COAL.get(), BlockEntityGasCoal::tick);
	}
}