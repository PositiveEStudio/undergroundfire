package dev.positivee.undergroundfire.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BlockEntityGasCoalExtractor extends BlockEntity
{
	protected int gasCoal = 0;

	public BlockEntityGasCoalExtractor(BlockPos pPos, BlockState pBlockState)
	{
		super(BlockEntityRegistry.GAS_COAL_EXTRACTOR.get(), pPos, pBlockState);
	}

	public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityGasCoalExtractor blockEntity)
	{
//		ArrayList<BlockPos> targetPos = new ArrayList<>();
//
//		for (int i = -1; i <= 1; i++)
//		{
//			for (int j = -1; j <= 1; j++)
//			{
//				for (int k = -1; k <= 1; k++)
//				{
//					if (i == 0 && j == 0 && k == 0) continue;
//
//					BlockPos newPos = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
//					Block block = level.getBlockState(newPos).getBlock();
//					if (block.equals(Blocks.AIR) || block.equals(BlockRegistry.GAS_COAL.get()))
//					{
//						targetPos.add(newPos);
//						if (level.isClientSide)
//							level.addParticle(DustParticleOptions.REDSTONE, true, newPos.getX(), newPos.getY(), newPos.getZ(), 0.0D, 0.0D, 0.0D);
//					}
//				}
//			}
//		}
//
//		if (!targetPos.isEmpty())
//		{
//			int index;
//
//			if (targetPos.size() == 1)
//				index = 0;
//			else
//				index = level.random.nextInt(0, targetPos.size() - 1);
//
//			BlockState targetState = level.getBlockState(targetPos.get(index));
//			Block targetBlock = targetState.getBlock();
//
//			if (!level.isClientSide)
//			{
//				int targetConcentration = targetState.getValue(BlockGasCoal.CONCENTRATION);
//
//				level.setBlock(targetPos.get(index), targetState.setValue(BlockGasCoal.CONCENTRATION, targetConcentration + 1), 2);
//				level.getBlockEntity(targetPos.get(index), BlockEntityRegistry.GAS_COAL.get()).get().isDelay();
//				level.setBlock(pos, blockEntity.getBlockState().setValue(BlockGasCoal.CONCENTRATION, (concentration >= 1) ? (concentration - 1) : 0), 2);
//			}
//		}
	}

	@Override
	protected void saveAdditional(CompoundTag pTag)
	{
		super.saveAdditional(pTag);
		pTag.putInt("GasCoal", this.gasCoal);
	}

	@Override
	public void load(CompoundTag pTag)
	{
		super.load(pTag);
		this.gasCoal = pTag.getInt("GasCoal");
	}

	@NotNull
	@Override
	public CompoundTag getUpdateTag()
	{
		// Server side, read NBT when updating chunk data
		CompoundTag nbt = super.getUpdateTag();
		nbt.putInt("GasCoal", this.gasCoal);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag)
	{
		// Client side, read NBT when updating chunk data
		super.load(tag);
		this.gasCoal = tag.getInt("GasCoal");
	}
}
