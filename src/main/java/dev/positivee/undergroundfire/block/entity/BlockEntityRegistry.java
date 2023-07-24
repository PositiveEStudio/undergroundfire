package dev.positivee.undergroundfire.block.entity;

import dev.positivee.undergroundfire.UndergroundFire;
import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UndergroundFire.MODID);

	public static final RegistryObject<BlockEntityType<BlockEntityRichCoalOre>> RICH_COAL_ORE = BLOCK_ENTITY_TYPE.register("rich_coal_ore", () -> BlockEntityType.Builder.of(BlockEntityRichCoalOre::new, BlockRegistry.RICH_COAL_ORE.get()).build(null));
	public static final RegistryObject<BlockEntityType<BlockEntityGasCoal>> GAS_COAL = BLOCK_ENTITY_TYPE.register("gas_coal", () -> BlockEntityType.Builder.of(BlockEntityGasCoal::new, BlockRegistry.GAS_COAL.get()).build(null));
	public static final RegistryObject<BlockEntityType<BlockEntityBurningRichCoalOre>> BURNING_RICH_COAL_ORE = BLOCK_ENTITY_TYPE.register("burning_rich_coal_ore", () -> BlockEntityType.Builder.of(BlockEntityBurningRichCoalOre::new, BlockRegistry.BURNING_RICH_COAL_ORE.get()).build(null));
	public static final RegistryObject<BlockEntityType<BlockEntityGasCoalExacter>> GAS_COAL_EXACTER = BLOCK_ENTITY_TYPE.register("gas_coal_exacter", () -> BlockEntityType.Builder.of(BlockEntityGasCoalExacter::new, BlockRegistry.GAS_COAL_EXACTER.get()).build(null));
}
