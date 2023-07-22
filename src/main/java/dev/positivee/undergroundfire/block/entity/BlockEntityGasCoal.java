package dev.positivee.undergroundfire.block.entity;

import dev.positivee.undergroundfire.block.BlockGasCoal;
import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BlockEntityGasCoal extends BlockEntity
{
	protected boolean delay = true;

	public BlockEntityGasCoal(BlockPos pPos, BlockState pBlockState)
	{
		super(BlockEntityRegistry.GAS_COAL.get(), pPos, pBlockState);
	}

	public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityGasCoal blockEntity)
	{
		ArrayList<BlockPos> targetPos = new ArrayList<>();
		int airCount = 0;
		int concentration = blockEntity.getBlockState().getValue(BlockGasCoal.CONCENTRATION);

		if (concentration == 0)
			level.removeBlock(pos, false);

		if (blockEntity.delay)
		{
			blockEntity.notDelay();
			return;
		}

		for (int i = -1; i <= 1; i++)
		{
			for (int j = -1; j <= 1; j++)
			{
				for (int k = -1; k <= 1; k++)
				{
					if (i == 0 && j == 0 && k == 0) continue;

					BlockPos newPos = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
					Block block = level.getBlockState(newPos).getBlock();
					if (block.equals(Blocks.AIR) || block.equals(BlockRegistry.GAS_COAL.get()))
					{
						targetPos.add(newPos);
//						if (level.isClientSide)
//							level.addParticle(DustParticleOptions.REDSTONE, true, newPos.getX(), newPos.getY(), newPos.getZ(), 0.0D, 0.0D, 0.0D);
					}
				}
			}
		}

		for (int i = 0; i < targetPos.size() - 1; i++)
			airCount++;

		if (!targetPos.isEmpty())
		{
//			Random random = new Random(pos.asLong() + state.getSeed(pos));
			int index;

			if (targetPos.size() == 1)
				index = 0;
			else
				index = level.random.nextInt(0, targetPos.size() - 1);

			BlockState targetState = level.getBlockState(targetPos.get(index));
			Block targetBlock = targetState.getBlock();

			if (!level.isClientSide)
			{
				if (airCount >= 20 && concentration < airCount * 0.8F)
				{
					level.removeBlock(pos, false);
				}
				else
				{
					if (targetBlock.equals(Blocks.AIR) && concentration > airCount * 0.8F)
					{
						level.setBlock(targetPos.get(index), BlockRegistry.GAS_COAL.get().defaultBlockState().setValue(BlockGasCoal.CONCENTRATION, 1), 2);
						level.setBlock(pos, blockEntity.getBlockState().setValue(BlockGasCoal.CONCENTRATION, concentration - 1), 2);
					}


//					if (targetBlock.equals(BlockRegistry.GAS_COAL.get()) && concentration - targetState.getValue(BlockGasCoal.CONCENTRATION) > 1)
					if (targetBlock.equals(BlockRegistry.GAS_COAL.get()) && concentration > targetState.getValue(BlockGasCoal.CONCENTRATION))
					{
						int targetConcentration = targetState.getValue(BlockGasCoal.CONCENTRATION);

						level.setBlock(targetPos.get(index), targetState.setValue(BlockGasCoal.CONCENTRATION, (targetConcentration <= 99 ? (targetConcentration + 1) : 100)), 2);
						level.getBlockEntity(targetPos.get(index), BlockEntityRegistry.GAS_COAL.get()).get().isDelay();
						level.setBlock(pos, blockEntity.getBlockState().setValue(BlockGasCoal.CONCENTRATION, (concentration >= 1) ? (concentration - 1) : 0), 2);
					}
				}
			}
		}
	}

	@Override
	protected void saveAdditional(CompoundTag pTag)
	{
		super.saveAdditional(pTag);
		pTag.putBoolean("Delay", this.delay);
	}

	@Override
	public void load(CompoundTag pTag)
	{
		super.load(pTag);
		this.delay = pTag.getBoolean("Delay");
	}

	@NotNull
	@Override
	public CompoundTag getUpdateTag()
	{
		// Server side, read NBT when updating chunk data
		CompoundTag nbt = super.getUpdateTag();
		nbt.putBoolean("Delay", this.delay);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag)
	{
		// Client side, read NBT when updating chunk data
		super.load(tag);
		this.delay = tag.getBoolean("Delay");
	}

	public void isDelay()
	{
		this.delay = true;
	}

	public void notDelay()
	{
		this.delay = false;
	}
}
