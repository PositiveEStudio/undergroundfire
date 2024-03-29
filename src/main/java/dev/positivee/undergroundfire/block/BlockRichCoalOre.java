package dev.positivee.undergroundfire.block;

import dev.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import dev.positivee.undergroundfire.block.entity.BlockEntityRichCoalOre;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockRichCoalOre extends BaseEntityBlock
{
	public BlockRichCoalOre()
	{
		super(Properties.copy(Blocks.COAL_ORE).ignitedByLava());
	}

	@NotNull
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit)
	{
		ItemStack itemStack = pPlayer.getItemInHand(pHand);
		if (!itemStack.is(Items.FLINT_AND_STEEL) && !itemStack.is(Items.FIRE_CHARGE))
		{
			return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
		}
		else
		{
			onCaughtFire(pState, pLevel, pPos, pHit.getDirection(), pPlayer);
			Item item = itemStack.getItem();
			if (!pPlayer.isCreative())
			{
				if (itemStack.is(Items.FLINT_AND_STEEL))
				{
					itemStack.hurtAndBreak(1, pPlayer, (p_57425_) ->
					{
						p_57425_.broadcastBreakEvent(pHand);
					});
				}
				else
				{
					itemStack.shrink(1);
				}
			}
			pPlayer.awardStat(Stats.ITEM_USED.get(item));
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		}
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid)
	{
		ItemStack itemStack = player.getMainHandItem();

		if (itemStack.is(Items.IRON_PICKAXE) && level.random.nextInt(1, 500) == 250 && !level.isClientSide)
		{
			level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1.5F, Level.ExplosionInteraction.BLOCK);
			return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
		}

		if (itemStack.is(Items.IRON_PICKAXE) && level.random.nextInt(1, 50) == 25 && !level.isClientSide)
		{
			level.setBlock(pos, Blocks.FIRE.defaultBlockState(), 2);
			return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
		}

		return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
	}

	@Override
	public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter)
	{
		burn(level, pos);
	}

	@Override
	public void wasExploded(Level pLevel, BlockPos pPos, Explosion pExplosion)
	{
		if (!pLevel.isClientSide)
			pLevel.setBlock(pPos, Blocks.FIRE.defaultBlockState(), 2);
	}

	@NotNull
	@Override
	public RenderShape getRenderShape(BlockState state)
	{
		return RenderShape.MODEL;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState)
	{
		return new BlockEntityRichCoalOre(pPos, pState);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType)
	{
		return pLevel.isClientSide ? null : createTickerHelper(pBlockEntityType, BlockEntityRegistry.RICH_COAL_ORE.get(), BlockEntityRichCoalOre::tick);
	}

	private static void burn(Level level, BlockPos pos)
	{
		if (!level.isClientSide())
		{
			level.setBlock(pos, BlockRegistry.BURNING_RICH_COAL_ORE.get().defaultBlockState(), 2);
		}
	}
}
