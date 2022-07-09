package xufly.groundfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class BlockGasCoal extends Block
{
	public BlockGasCoal()
	{
		super(Properties.of(Material.AIR).noCollission().noDrops());
	}

	@Override
	public RenderShape getRenderShape(BlockState p_48758_)
	{
		return RenderShape.INVISIBLE;
	}

	@Override
	public InteractionResult use(BlockState p_60503_, Level p_60504_, BlockPos p_60505_, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_)
	{
		if (!p_60504_.isClientSide() && p_60506_.getMainHandItem().getItem().equals(Items.FLINT_AND_STEEL))
		{
			p_60504_.explode(null, p_60505_.getX(), p_60505_.getY(), p_60505_.getZ(), 3, Explosion.BlockInteraction.DESTROY);
			return InteractionResult.SUCCESS;
		}
		else
		{
			return InteractionResult.FAIL;
		}
	}
}
