package xufly.groundfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;
import xufly.groundfire.block.entity.BlockEntityBurningRichCoalOre;
import xufly.groundfire.block.entity.BlockEntityRegistry;

public class BlockBurningRichCoalOre extends BaseEntityBlock
{
	public static final BooleanProperty BURN = BooleanProperty.create("can_burn_out");

	public BlockBurningRichCoalOre()
	{
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(2.8F, 2.8F).requiresCorrectToolForDrops().sound(SoundType.STONE));
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
		return state.getValue(BURN) && !world.isClientSide && type.equals(BlockEntityRegistry.blockEntityBurningRichCoal.get()) ? createTickerHelper(type, BlockEntityRegistry.blockEntityBurningRichCoal.get(), BlockEntityBurningRichCoalOre::tick) : null;
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
