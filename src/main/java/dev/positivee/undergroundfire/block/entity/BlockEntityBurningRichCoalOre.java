package dev.positivee.undergroundfire.block.entity;

import dev.positivee.undergroundfire.block.BlockBurningRichCoalOre;
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
import java.util.Random;

public class BlockEntityBurningRichCoalOre extends BlockEntity
{
	int delay;

	public BlockEntityBurningRichCoalOre(BlockPos pPos, BlockState pBlockState)
	{
		super(BlockEntityRegistry.BURNING_RICH_COAL_ORE.get(), pPos, pBlockState);
		this.InitDelay();
	}

	public static void tick(Level level, BlockPos pos, BlockState state, BlockEntityBurningRichCoalOre blockEntity)
	{
		int outputs = blockEntity.getBlockState().getValue(BlockBurningRichCoalOre.OUTPUTS);
		Boolean canBurnOut = blockEntity.getBlockState().getValue(BlockBurningRichCoalOre.CAN_BURN_OUT);

		if (!canBurnOut)
			return;

		blockEntity.DecreaseDelay();

		if (outputs != 0 && blockEntity.getDelay() == 0)
		{
			blockEntity.InitDelay();

			ArrayList<BlockPos> targetPos = new ArrayList<>();

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
							targetPos.add(newPos);
					}
				}
			}

			if (!targetPos.isEmpty())
			{
				Random random = new Random(pos.asLong() + state.getSeed(pos));
				int index;

				if (targetPos.size() == 1)
					index = 0;
				else
					index = random.nextInt(0, targetPos.size() - 1);

				BlockState targetState = level.getBlockState(targetPos.get(index));
				Block targetBlock = targetState.getBlock();

				if (!level.isClientSide)
				{
					if (targetBlock.equals(Blocks.AIR))
					{
						level.setBlock(targetPos.get(index), BlockRegistry.GAS_COAL.get().defaultBlockState().setValue(BlockGasCoal.CONCENTRATION, 1), 2);
						level.setBlock(pos, blockEntity.getBlockState().setValue(BlockBurningRichCoalOre.OUTPUTS, outputs - 1), 2);
					}

					if (targetBlock.equals(BlockRegistry.GAS_COAL.get()))
					{
						level.setBlock(targetPos.get(index), targetState.setValue(BlockGasCoal.CONCENTRATION, targetState.getValue(BlockGasCoal.CONCENTRATION) + 1), 2);
						level.getBlockEntity(targetPos.get(index), BlockEntityRegistry.GAS_COAL.get()).get().isDelay();
						level.setBlock(pos, blockEntity.getBlockState().setValue(BlockBurningRichCoalOre.OUTPUTS, outputs - 1), 2);
					}

				}
			}
		}
		else if (outputs == 0)
			level.removeBlock(pos, false);
	}

	protected void saveAdditional(CompoundTag pTag)
	{
		super.saveAdditional(pTag);
		pTag.putInt("Delay", this.delay);
	}

	@Override
	public void load(CompoundTag pTag)
	{
		super.load(pTag);
		this.delay = pTag.getInt("Delay");
	}

	@NotNull
	@Override
	public CompoundTag getUpdateTag()
	{
		// Server side, read NBT when updating chunk data
		CompoundTag nbt = super.getUpdateTag();
		nbt.putInt("Delay", this.delay);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag)
	{
		// Client side, read NBT when updating chunk data
		super.load(tag);
		this.delay = tag.getInt("Delay");
	}

	private void InitDelay()
	{
		Random random = new Random(this.getBlockPos().asLong() + this.getBlockState().getSeed(this.getBlockPos()));
		this.delay = random.nextInt(225, 375);
	}

	public void DecreaseDelay()
	{
		this.delay--;
	}

	public int getDelay()
	{
		return this.delay;
	}
}
