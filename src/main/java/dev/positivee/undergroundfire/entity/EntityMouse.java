package dev.positivee.undergroundfire.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityMouse extends Entity
{
	public EntityMouse(EntityType<?> pEntityType, Level pLevel)
	{
		super(pEntityType, pLevel);
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
