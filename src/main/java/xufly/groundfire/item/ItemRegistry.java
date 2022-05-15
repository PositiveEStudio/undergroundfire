package xufly.groundfire.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;
import xufly.groundfire.block.BlockRegistry;
import xufly.groundfire.creative.GFCreativeTab;
import xufly.groundfire.fluid.FluidRegistry;

public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GroundFire.MODID);

	public static final RegistryObject<Item> mouse = ITEMS.register("mouse", ItemMouse::new);

	public static final RegistryObject<Item> coalGasBucket = ITEMS.register("coal_gas_bucket", () -> new BucketItem(FluidRegistry.coalGasSource, new Item.Properties().tab(GFCreativeTab.GF_TAB)));

	public static final RegistryObject<BlockItem> richCoalOre = ITEMS.register("rich_coal_ore", () -> new BlockItem(BlockRegistry.richCoalOre.get(), new Item.Properties().tab(GFCreativeTab.GF_TAB)));
	public static final RegistryObject<BlockItem> burningRichCoalOre = ITEMS.register("burning_rich_coal_ore", () -> new BlockItem(BlockRegistry.burningCoalOer.get(), new Item.Properties().tab(GFCreativeTab.GF_TAB)));

}
