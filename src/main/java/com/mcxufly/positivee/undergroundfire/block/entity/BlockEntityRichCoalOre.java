package com.mcxufly.positivee.undergroundfire.block.entity;

import com.mcxufly.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

import static com.mcxufly.positivee.undergroundfire.common.CheckBlock.CheckAroundFireBlock;

public class BlockEntityRichCoalOre extends BlockEntity
{
	protected int burnTime;
	protected int toBurnTime;

	public BlockEntityRichCoalOre(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.RICH_COAL_ORE.get(), pos, state);
		this.IntiToBurnTime();
	}

	public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityRichCoalOre blockEntity)
	{
		if (CheckAroundFireBlock(level, pos))
			blockEntity.burnTime++;
		if (blockEntity.getBurnTime() > blockEntity.getToBurnTime() && !level.isClientSide())
			level.setBlock(pos, BlockRegistry.BURNING_RICH_COAL_ORE.get().defaultBlockState(), 2);
	}

	@Override
	protected void saveAdditional(CompoundTag pTag)
	{
		super.saveAdditional(pTag);
		pTag.putInt("BurnTime", this.burnTime);
		pTag.putInt("ToBurnTime", this.toBurnTime);
	}

	@Override
	public void load(CompoundTag pTag)
	{
		super.load(pTag);
		this.burnTime = pTag.getInt("BurnTime");
		this.toBurnTime = pTag.getInt("ToBurnTime");
	}

	private void IntiToBurnTime()
	{
		Random random = new Random(this.getBlockPos().asLong() + this.getBlockState().getSeed(this.getBlockPos()));
		this.toBurnTime = random.nextInt(90, 150);
	}

	private void IncreaseBurnTime()
	{
		this.burnTime++;
	}

	private int getBurnTime()
	{
		return burnTime;
	}

	private int getToBurnTime()
	{
		return toBurnTime;
	}

	private void setBurnTime(int burnTime)
	{
		this.burnTime = burnTime;
	}

	private void setToBurnTime(int toBurnTime)
	{
		this.toBurnTime = toBurnTime;
	}
}
