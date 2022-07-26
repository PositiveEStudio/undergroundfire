package xufly.groundfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import xufly.groundfire.block.entity.BlockEntityRegistry;
import xufly.groundfire.block.entity.BlockEntityRichCoalOre;

public class BlockRichCoalOre extends BaseEntityBlock
{
	public BlockRichCoalOre()
	{
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops());
	}

	@Override
	public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_)
	{
		if (p_60506_.getMainHandItem().getItem().equals(Items.FLINT_AND_STEEL))
		{
			p_60504_.setBlock(p_60505_, BlockRegistry.burningRichCoalOre.get().defaultBlockState(), 1);
			return InteractionResult.SUCCESS;
		}
		else
		{
			return InteractionResult.FAIL;
		}
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlockEntityRichCoalOre(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type)
	{
		return !world.isClientSide && type.equals(BlockEntityRegistry.entityBlockRichCoalOre.get()) ? createTickerHelper(type, BlockEntityRegistry.entityBlockRichCoalOre.get(), BlockEntityRichCoalOre::tick) : null;
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_)
	{
		return RenderShape.MODEL;
	}
}
