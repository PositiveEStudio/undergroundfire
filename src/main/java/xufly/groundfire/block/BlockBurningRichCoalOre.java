package xufly.groundfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import xufly.groundfire.block.entity.BlockEntityBurningRichCoalOre;
import xufly.groundfire.block.entity.BlockEntityRegistry;
import xufly.groundfire.item.ItemRegistry;

public class BlockBurningRichCoalOre extends BaseEntityBlock
{
	public static final BooleanProperty BURN = BooleanProperty.create("can_burn_out");

	public BlockBurningRichCoalOre()
	{
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(2.8F, 2.8F).requiresCorrectToolForDrops());
		this.registerDefaultState(this.getStateDefinition().any().setValue(BURN, true));
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlockEntityBurningRichCoalOre(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type)
	{
		return state.getValue(BURN) && !world.isClientSide && type.equals(BlockEntityRegistry.entityBlockBurningRichCoal.get()) ? createTickerHelper(type, BlockEntityRegistry.entityBlockBurningRichCoal.get(), BlockEntityBurningRichCoalOre::tick) : null;
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
	{
		if (!world.isClientSide && player.getMainHandItem().getItem().equals(ItemRegistry.debugStick.get()))
		{
			world.setBlock(pos, state.setValue(BURN, !state.getValue(BURN)), 2);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
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
