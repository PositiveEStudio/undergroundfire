package dev.positivee.undergroundfire.block;

import dev.positivee.undergroundfire.block.entity.BlockEntityGasCoalExtractor;
import dev.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import dev.positivee.undergroundfire.gui.menu.MenuGasCoalExtractor;
import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockGasCoalExtractor extends BaseEntityBlock
{
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty TANK = BooleanProperty.create("tank");
	private static final Component TITLE = Component.translatable("title.extractor");

	public BlockGasCoalExtractor()
	{
		super(Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL));
		this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(TANK, false));
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit)
	{
		ItemStack item = pPlayer.getItemInHand(pHand);
		if (item.is(ItemRegistry.GAS_TANK.get()))
		{
			if (!pLevel.isClientSide)
				pPlayer.sendSystemMessage(Component.translatable("block.undergroundfire.gas_coal_extractor.get_gas_tank"));
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		}
		else
		{
			BlockEntityGasCoalExtractor blockentity = pLevel.getBlockEntity(pPos, BlockEntityRegistry.GAS_COAL_EXTRACTOR.get()).get();
			if (!pLevel.isClientSide)
				pPlayer.sendSystemMessage(Component.translatable("block.undergroundfire.gas_coal_extractor.get_no_gas_tank", blockentity.getGasCoal()));

			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		}
	}

	@Nullable
	@Override
	public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos)
	{
		return new SimpleMenuProvider((pContainerId, playerInv, player) ->
				new MenuGasCoalExtractor(pContainerId, playerInv), TITLE);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext)
	{
		return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction)
	{
		return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
	{
		pBuilder.add(FACING).add(TANK);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
	{
		return new BlockEntityGasCoalExtractor(pPos, pState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType)
	{
		return pLevel.isClientSide ? null : createTickerHelper(pBlockEntityType, BlockEntityRegistry.GAS_COAL_EXTRACTOR.get(), BlockEntityGasCoalExtractor::tick);
	}

	@NotNull
	@Override
	public RenderShape getRenderShape(BlockState state)
	{
		return RenderShape.MODEL;
	}
}
