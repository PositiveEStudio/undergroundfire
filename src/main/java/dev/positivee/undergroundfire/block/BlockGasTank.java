package dev.positivee.undergroundfire.block;

import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BlockGasTank extends Block
{
	public static final IntegerProperty TOLERANCE = IntegerProperty.create("tolerance", 0, 10);
	private static VoxelShape shape;

	static
	{
		VoxelShape block1 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
		shape = Shapes.or(block1);
	}

	public BlockGasTank()
	{
		super(Properties.of().sound(SoundType.ANVIL));
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit)
	{//TODO:在冒烟位置生成实体释放粒子效果，并发出点燃的声音，延时一定时间后爆炸，根据 tolerance 值去设定爆炸等级，tolerance 值为 0 时不触发
		return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
	}

	@Override
	public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag)
	{
		if(pStack.getOrCreateTag().contains("tolerance"))
		{
			pTooltip.add(Component.translatable("block.undergroundfire.gas_coal.tolerance",
					pStack.getTag().get("tolerance")).withStyle(ChatFormatting.BLUE));
		}
		else
		{
			pStack.getOrCreateTag().putInt("tolerance", 0);
			pTooltip.add(Component.translatable("block.undergroundfire.gas_coal.tolerance",
					pStack.getTag().get("tolerance")).withStyle(ChatFormatting.BLUE));
		}
	}

	@Override
	public List<ItemStack> getDrops(BlockState pState, LootParams.Builder pParams)
	{
		List<ItemStack> drops = new ArrayList<>();
		ItemStack drop = new ItemStack(ItemRegistry.GAS_TANK.get(), 1);
//		drop.addTagElement("tolerance", IntTag.valueOf(pState.getValue(TOLERANCE)));
		drop.getOrCreateTag().putInt("tolerance", pState.getValue(TOLERANCE));
		drops.add(drop);
		return drops;
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack)
	{
		if (pStack.getOrCreateTag().contains("tolerance"))
		{
			pLevel.setBlockAndUpdate(pPos,pState.setValue(TOLERANCE, pStack.getOrCreateTag().getInt("tolerance")));
		}
		else
		{
			pState.setValue(TOLERANCE, 0);
		}
		super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
	{
		pBuilder.add(TOLERANCE);
	}

	@NotNull
	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
	{
		return shape;
	}

}
