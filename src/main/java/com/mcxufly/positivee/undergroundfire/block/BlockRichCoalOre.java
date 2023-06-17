package com.mcxufly.positivee.undergroundfire.block;

import com.mcxufly.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import com.mcxufly.positivee.undergroundfire.block.entity.BlockEntityRichCoalOre;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

/*public class BlockRichCoalOre extends Block
{
    public BlockRichCoalOre()
    {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
    }

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
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter)
    {
        burn(level, pos, igniter);
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    private static void burn(Level level, BlockPos pos, @Nullable LivingEntity entity)
    {
        if (!level.isClientSide())
        {
            level.setBlock(pos, BlockRegistry.burningRichCoalOre.get().defaultBlockState(), 2);
        }
    }
}*/

public class BlockRichCoalOre extends BaseEntityBlock
{
    public BlockRichCoalOre()
    {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3.0F, 3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE));
    }

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
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter)
    {
        burn(level, pos, igniter);
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
        return !world.isClientSide && type.equals(BlockEntityRegistry.blockEntityRichCoalOre.get()) ? createTickerHelper(type, BlockEntityRegistry.blockEntityRichCoalOre.get(), BlockEntityRichCoalOre::tick) : null;
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    private static void burn(Level level, BlockPos pos, @Nullable LivingEntity entity)
    {
        if (!level.isClientSide())
        {
            level.setBlock(pos, BlockRegistry.burningRichCoalOre.get().defaultBlockState(), 2);
        }
    }
}
