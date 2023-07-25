package dev.positivee.undergroundfire.entity;

import dev.positivee.undergroundfire.block.BlockGasCoal;
import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class EntityMouse extends Entity
{
	protected EntityMouse(EntityType<? extends EntityMouse> pEntityType, Level pLevel)
	{
		super(pEntityType, pLevel);
	}

	public static AttributeSupplier.Builder createAttributes()
	{
		return LivingEntity.createLivingAttributes().add(Attributes.MAX_HEALTH, 1.0D);
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

//		super.tick();
	}

	private static Vector3f getParticleColor(int targetConc)
	{
		int red, green;
		String color_s;
		if (((double) targetConc / 50.0D) < 1.0D)
		{
			red = (int) (255 * ((double) targetConc / 50.0D));
			green = 255 - red;
			color_s = Integer.toHexString(red) + Integer.toHexString(green) + "00";
		}
		else
		{
			color_s = "ff0000";
		}

		int color = Integer.valueOf(color_s, 16);
		return Vec3.fromRGB24(color).toVector3f();
	}
}
