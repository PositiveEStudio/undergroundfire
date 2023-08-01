package dev.positivee.undergroundfire.block.entity;

import com.mojang.logging.LogUtils;
import dev.positivee.undergroundfire.block.BlockGasCoal;
import dev.positivee.undergroundfire.block.BlockRegistry;
import dev.positivee.undergroundfire.common.Constants;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.ArrayList;

import static dev.positivee.undergroundfire.block.BlockGasCoalExtractor.FACING;

public class BlockEntityGasCoalExtractor extends BlockEntity
{
	private int gasCoal = 0;

	public BlockEntityGasCoalExtractor(BlockPos pPos, BlockState pBlockState)
	{
		super(BlockEntityRegistry.GAS_COAL_EXTRACTOR.get(), pPos, pBlockState);
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, BlockEntityGasCoalExtractor blockEntity)
	{
		int direction = blockEntity.getBlockState().getValue(FACING).get2DDataValue();
		int[] dxyz1, dxyz2;
		dxyz1 = new int[3];
		dxyz2 = new int[3];

		//(x,y,z)
		//facing west (1,-3,-3)->(7,3,3)
		//facing east (-1,3,3)->(-7,-3,-3)
		//facing north (3,3,7)->(-3,-3,1)
		//facing south (3,3,-1)->(-3,-3,-7)

		switch (direction)
		{
			case 0://south
			{
				dxyz1 = new int[]{3, 3, -1};
				dxyz2 = new int[]{-3, -3, -7};
				break;
			}
			case 1://west
			{
				dxyz1 = new int[]{1, -3, -3};
				dxyz2 = new int[]{7, 3, 3};
				break;
			}
			case 2://north
			{
				dxyz1 = new int[]{3, 3, 7};
				dxyz2 = new int[]{-3, -3, 1};
				break;
			}
			case 3://east
			{
				dxyz1 = new int[]{-1, 3, 3};
				dxyz2 = new int[]{-7, -3, -3};
				break;
			}
		}

		BlockPos start = new BlockPos(pPos.getX() + dxyz1[0], pPos.getY() + dxyz1[1], pPos.getZ() + dxyz1[2]);
		BlockPos end = new BlockPos(pPos.getX() + dxyz2[0], pPos.getY() + dxyz2[1], pPos.getZ() + dxyz2[2]);
		ArrayList<BlockPos> targetPosS = new ArrayList<>();

		for (BlockPos nextPos : BlockPos.betweenClosed(start, end))
		{
			if (pLevel.getBlockState(nextPos).is(BlockRegistry.GAS_COAL.get()))
			{
				targetPosS.add(new BlockPos(nextPos.getX(), nextPos.getY(), nextPos.getZ()));
			}
		}

		if (!targetPosS.isEmpty())
		{
			int index;
			if (targetPosS.size() == 1)
				index = 0;
			else
				index = pLevel.random.nextInt(0, targetPosS.size() - 1);

			BlockPos targetPos = targetPosS.get(index);
			BlockState targetState = pLevel.getBlockState(targetPos);

			if (!pLevel.isClientSide)
			{
				int targetConcentration = targetState.getValue(BlockGasCoal.CONCENTRATION);

				pLevel.setBlockAndUpdate(targetPos, BlockRegistry.GAS_COAL.get().defaultBlockState()
						.setValue(BlockGasCoal.CONCENTRATION, (targetConcentration > Constants.CONC_MIN) ?
								(targetConcentration - 1) : 0));
				pLevel.getBlockEntity(targetPos, BlockEntityRegistry.GAS_COAL.get()).get().isDelay();
				blockEntity.increaseGasCoal();
			}
		}
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

	public int getGasCoal()
	{
		return this.gasCoal;
	}

	public void increaseGasCoal()
	{
		this.gasCoal++;
	}

	public void decreaseGasCoal()
	{
		if (this.gasCoal > 0)
		{
			this.gasCoal--;
		}
		else
		{
			Logger logger = LogUtils.getLogger();
			logger.warn("the " + this.getBlockState().getBlock().toString() + " in " + this.getBlockPos().toString() + " is tried to be below 0");
		}
	}

	public void decreaseGasCoal(int decrease)
	{
		this.gasCoal -= decrease;
	}
}
