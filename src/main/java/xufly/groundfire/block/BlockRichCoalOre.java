package xufly.groundfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class BlockRichCoalOre extends Block
{
	static boolean flag = true;

	public BlockRichCoalOre()
	{
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).strength(3.1F, 3.1F).requiresCorrectToolForDrops());
	}

	@Override
	public void tick(BlockState p_60462_, ServerLevel p_60463_, BlockPos p_60464_, Random p_60465_)
	{
		if (checkAroundBlock(p_60463_, p_60464_))
		{
			System.out.println("yes");
			p_60463_.setBlock(p_60464_, BlockRegistry.burningCoalOer.get().defaultBlockState(), 1);
		}
		else
		{
			if (flag)
				System.out.println("fuck");
			flag = false;
		}
	}

	@Override
	public boolean isRandomlyTicking(BlockState p_49921_)
	{
		return true;
	}

	@Override
	public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_)
	{
		if (p_60506_.getMainHandItem().getItem().equals(Items.FLINT_AND_STEEL))
		{
			p_60504_.setBlock(p_60505_, BlockRegistry.burningCoalOer.get().defaultBlockState(), 1);
			return InteractionResult.SUCCESS;
		}
		else
		{
			return InteractionResult.FAIL;
		}
	}

	private boolean checkAroundBlock(ServerLevel level, BlockPos pos)
	{
		/*int[][] dxyz = new int[][]{{0, 1, 0},};
		for (int[] d : dxyz)
		{
			if (level.getBlockState(new BlockPos(pos.getX() + d[0], pos.getY() + d[1], pos.getZ() + d[2])).getBlock().equals(Blocks.FIRE))
			{
				System.out.println("fire!");
				return true;
			}
		}*/
		if (level.getBlockState(pos.above()).getBlock().equals(Blocks.FIRE))
		{
			System.out.println("true");
			return true;
		}
		else
		{
			System.out.println("false");
			return false;
		}
	}
}
