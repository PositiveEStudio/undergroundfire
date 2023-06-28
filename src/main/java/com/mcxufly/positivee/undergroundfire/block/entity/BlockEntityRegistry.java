package com.mcxufly.positivee.undergroundfire.block.entity;

import com.mcxufly.positivee.undergroundfire.UndergroundFire;
import com.mcxufly.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UndergroundFire.MODID);

	public static final RegistryObject<BlockEntityType<BlockEntityRichCoalOre>> RICH_COAL_ORE = BLOCK_ENTITY_TYPE.register("rich_coal_ore", () -> BlockEntityType.Builder.of(BlockEntityRichCoalOre::new, BlockRegistry.RICH_COAL_ORE.get()).build(null));
}
