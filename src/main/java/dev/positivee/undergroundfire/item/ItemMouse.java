package dev.positivee.undergroundfire.item;

import dev.positivee.undergroundfire.entity.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Objects;

public class ItemMouse extends Item
{
	public ItemMouse()
	{
		super(new Properties());
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext)
	{
		Level level = pContext.getLevel();
		if (!(level instanceof ServerLevel))
		{
			return InteractionResult.SUCCESS;
		}
		else
		{
			ItemStack itemstack = pContext.getItemInHand();
			BlockPos blockpos = pContext.getClickedPos();
			Direction direction = pContext.getClickedFace();
			BlockState blockstate = level.getBlockState(blockpos);

			BlockPos blockPos1;

			if (blockstate.getCollisionShape(level, blockpos).isEmpty())
			{
				blockPos1 = blockpos;
			}
			else
			{
				blockPos1 = blockpos.relative(direction);
			}

			if (EntityRegistry.MOUSE.get().spawn((ServerLevel) level, itemstack, pContext.getPlayer(), blockPos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockPos1) && direction == Direction.UP) != null)
			{
				itemstack.shrink(1);
				level.gameEvent(pContext.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
			}

			return InteractionResult.CONSUME;
		}
	}
}