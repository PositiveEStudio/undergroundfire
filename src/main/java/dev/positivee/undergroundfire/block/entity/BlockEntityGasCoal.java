package dev.positivee.undergroundfire.block.entity;

import com.mojang.logging.LogUtils;
import dev.positivee.undergroundfire.UndergroundFire;
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
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class BlockEntityGasCoal extends BlockEntity
{
	protected int concentration;

	public BlockEntityGasCoal(BlockPos pPos, BlockState pBlockState)
	{
		super(BlockEntityRegistry.GAS_COAL.get(), pPos, pBlockState);
		concentration = pBlockState.getValue(BlockGasCoal.CONCENTRATION);
	}

	public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityGasCoal blockEntity)
	{//TODO:继续改写 tick 方法直至有正常的扩散效果
		ArrayList<BlockPos> targetPos = new ArrayList<>();
		int allIsAir = 0;

		for (int i = -1; i < 1; i++)
		{
			for (int j = -1; j < 1; j++)
			{
				for (int k = -1; k < 1; k++)
				{
					if (i == 0 && j == 0 && k == 0)
						continue;
					BlockPos newPos = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
					Block block = level.getBlockState(newPos).getBlock();
					if (block.equals(Blocks.AIR) || block.equals(BlockRegistry.GAS_COAL.get()))
						targetPos.add(newPos);
				}
			}
		}

		for (int i = 0; i < targetPos.size() - 1; i++)
		{
			allIsAir++;
		}

		if (!targetPos.isEmpty())
		{
			Random random = new Random(pos.asLong() + state.getSeed(pos));
			int index;
			if (targetPos.size() == 1)
			{
				index = 0;
			}
			else
			{
				index = random.nextInt(0, targetPos.size() - 1);
			}

			BlockState targetState = level.getBlockState(targetPos.get(index));
			Block targetBlock = targetState.getBlock();

			if (!level.isClientSide)
			{
				if (allIsAir >= 20 && blockEntity.concentration <= 1)
				{
					level.removeBlock(pos, false);
				}

				if (targetBlock.equals(Blocks.AIR))
				{
					level.setBlock(targetPos.get(index), BlockRegistry.GAS_COAL.get().defaultBlockState().setValue(BlockGasCoal.CONCENTRATION, 1), 2);

					blockEntity.decreaseConcentration();
					level.setBlock(pos, blockEntity.getBlockState().setValue(BlockGasCoal.CONCENTRATION, blockEntity.concentration),2);
				}

				if (targetBlock.equals(BlockRegistry.GAS_COAL.get()) && blockEntity.concentration - targetState.getValue(BlockGasCoal.CONCENTRATION) > 1)
				{
					level.setBlock(targetPos.get(index), targetState.setValue(BlockGasCoal.CONCENTRATION, targetState.getValue(BlockGasCoal.CONCENTRATION) + 1), 2);

					blockEntity.decreaseConcentration();
					level.setBlock(pos, blockEntity.getBlockState().setValue(BlockGasCoal.CONCENTRATION, blockEntity.concentration),2);
				}
			}

		}
	}

	@Override
	protected void saveAdditional(CompoundTag pTag)
	{
		super.saveAdditional(pTag);
		pTag.putInt("concentration", this.concentration);
	}

	@Override
	public void load(CompoundTag pTag)
	{
		super.load(pTag);
		this.concentration = pTag.getInt("concentration");
	}

	@NotNull
	@Override
	public CompoundTag getUpdateTag()
	{
		// Server side, read NBT when updating chunk data
		CompoundTag nbt = super.getUpdateTag();
		nbt.putInt("concentration", this.concentration);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag)
	{
		// Client side, read NBT when updating chunk data
		super.load(tag);
		this.concentration = tag.getInt("concentration");
	}

	public void increaseConcentration()
	{
		if (this.concentration < 1000)
			this.concentration++;
	}

	public void decreaseConcentration()
	{
		if (this.concentration > 0)
			this.concentration--;
	}
}
