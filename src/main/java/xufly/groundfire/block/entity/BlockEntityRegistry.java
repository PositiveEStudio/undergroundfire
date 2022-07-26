package xufly.groundfire.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;
import xufly.groundfire.block.BlockRegistry;

public class BlockEntityRegistry
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, GroundFire.MODID);

	public static final RegistryObject<BlockEntityType<BlockEntityRichCoalOre>> entityBlockRichCoalOre = BLOCK_ENTITIES.register("rich_coal_ore", () -> BlockEntityType.Builder.of(BlockEntityRichCoalOre::new, BlockRegistry.richCoalOre.get()).build(null));
	public static final RegistryObject<BlockEntityType<BlockEntityBurningRichCoalOre>> entityBlockBurningRichCoal = BLOCK_ENTITIES.register("burning_rich_coal_ore", () -> BlockEntityType.Builder.of(BlockEntityBurningRichCoalOre::new, BlockRegistry.burningRichCoalOre.get()).build(null));
}
