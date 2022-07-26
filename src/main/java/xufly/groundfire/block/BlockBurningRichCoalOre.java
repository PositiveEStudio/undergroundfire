package xufly.groundfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;
import xufly.groundfire.block.entity.BlockEntityBurningRichCoalOre;
import xufly.groundfire.block.entity.BlockEntityRegistry;

public class BlockBurningRichCoalOre extends BaseEntityBlock
{
	public BlockBurningRichCoalOre()
	{
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(2.8F, 2.8F).requiresCorrectToolForDrops());
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
		return !world.isClientSide && type.equals(BlockEntityRegistry.entityBlockBurningRichCoal.get()) ? createTickerHelper(type, BlockEntityRegistry.entityBlockBurningRichCoal.get(), BlockEntityBurningRichCoalOre::tick) : null;
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_)
	{
		return RenderShape.MODEL;
	}
}
