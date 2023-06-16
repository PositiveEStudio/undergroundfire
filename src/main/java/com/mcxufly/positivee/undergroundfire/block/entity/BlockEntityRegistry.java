package com.mcxufly.positivee.undergroundfire.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.mcxufly.positivee.undergroundfire.UndergroundFire;
import com.mcxufly.positivee.undergroundfire.block.BlockRegistry;

public class BlockEntityRegistry
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, UndergroundFire.MODID);

	public static final RegistryObject<BlockEntityType<BlockEntityRichCoalOre>> blockEntityRichCoalOre = BLOCK_ENTITIES.register("rich_coal_ore", () -> BlockEntityType.Builder.of(BlockEntityRichCoalOre::new, BlockRegistry.richCoalOre.get()).build(null));
	public static final RegistryObject<BlockEntityType<BlockEntityBurningRichCoalOre>> blockEntityBurningRichCoal = BLOCK_ENTITIES.register("burning_rich_coal_ore", () -> BlockEntityType.Builder.of(BlockEntityBurningRichCoalOre::new, BlockRegistry.burningRichCoalOre.get()).build(null));
	public static final RegistryObject<BlockEntityType<BlockEntityExtractor>> blockEntityExtractor = BLOCK_ENTITIES.register("extractor", () -> BlockEntityType.Builder.of(BlockEntityExtractor::new, BlockRegistry.extractor.get()).build(null));
}
