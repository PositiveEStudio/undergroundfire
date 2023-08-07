package dev.positivee.undergroundfire.entity;

import dev.positivee.undergroundfire.block.BlockGasCoal;
import dev.positivee.undergroundfire.block.BlockRegistry;
import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import static dev.positivee.undergroundfire.common.GetGYRColor.getParticleColor;

public class EntityMouse extends Entity
{
	protected EntityMouse(EntityType<? extends EntityMouse> pEntityType, Level pLevel)
	{
		super(pEntityType, pLevel);
	}

	@Override
	public void tick()
	{
		BlockPos pos = this.getOnPos();

		for (int i = -3; i <= 3; i++)
		{
			for (int j = -3; j <= 3; j++)
			{
				for (int k = -3; k <= 3; k++)
				{
					BlockPos targetPos = new BlockPos(pos.getX() + i, pos.getY() + j, pos.getZ() + k);
					BlockState targetState = this.level().getBlockState(targetPos);
					if (targetState.is(BlockRegistry.GAS_COAL.get()))
					{
						this.level().addParticle(new DustParticleOptions(getParticleColor(targetState.getValue(BlockGasCoal.CONCENTRATION)), 1.0F), true, targetPos.getX() + 0.5D, targetPos.getY() + 0.5D, targetPos.getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
					}
				}
			}
		}

		super.tick();
	}

	@Override
	public boolean hurt(DamageSource pSource, float pAmount)
	{
		if (!this.level().isClientSide && !this.isRemoved())
		{
			if (this.isInvulnerableTo(pSource))
			{
				return false;
			}
			else
			{
				this.markHurt();
				this.gameEvent(GameEvent.ENTITY_DAMAGE, pSource.getEntity());

				boolean flag = pSource.getEntity() instanceof Player && ((Player) pSource.getEntity()).getAbilities().instabuild;

				if (flag)
				{
					this.ejectPassengers();
					if (!this.hasCustomName())
					{
						this.discard();
					}
					else
					{
						this.destroy(pSource);
					}
				}
				else
				{
					this.destroy(pSource);
				}

				return true;
			}
		}
		else
		{
			return true;
		}
	}

	public void destroy(DamageSource pDamageSource)
	{
		this.kill();
		if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS))
		{
			ItemStack itemstack = new ItemStack(ItemRegistry.MOUSE.get());
			if (this.hasCustomName())
			{
				itemstack.setHoverName(this.getCustomName());
			}
			this.spawnAtLocation(itemstack);
		}

	}

	@Override
	public boolean isPickable()
	{
		return true;
	}

	@Nullable
	@Override
	public ItemStack getPickResult()
	{
		return new ItemStack(ItemRegistry.MOUSE.get());
	}

	@Override
	protected void defineSynchedData()
	{

	}

	@Override
	protected void readAdditionalSaveData(CompoundTag pCompound)
	{

	}

	@Override
	protected void addAdditionalSaveData(CompoundTag pCompound)
	{

	}
}
