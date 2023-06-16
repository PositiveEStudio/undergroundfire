package com.mcxufly.positivee.undergroundfire.block;

import com.mcxufly.positivee.undergroundfire.block.entity.BlockEntityExtractor;
import com.mcxufly.positivee.undergroundfire.block.entity.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class BlockExtractor extends BaseEntityBlock
{
	public BlockExtractor()
	{
		super(Properties.of(Material.METAL).strength(4.5F, 5.5F).sound(SoundType.METAL));
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
	{
		//潜行状态
		if (player.isShiftKeyDown())
		{
			//返回跳过
			return InteractionResult.PASS;
		}
		//获取方块实体
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (!world.isClientSide && blockEntity instanceof BlockEntityExtractor)
		{
			//打开gui
			NetworkHooks.openGui((ServerPlayer) player, (MenuProvider) blockEntity, pos);
		}

		return InteractionResult.SUCCESS;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlockEntityExtractor(pos, state);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type)
	{
		return !world.isClientSide && type.equals(BlockEntityRegistry.blockEntityExtractor.get()) ? createTickerHelper(type, BlockEntityRegistry.blockEntityExtractor.get(), BlockEntityExtractor::tick) : null;
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_)
	{
		return RenderShape.MODEL;
	}
}
