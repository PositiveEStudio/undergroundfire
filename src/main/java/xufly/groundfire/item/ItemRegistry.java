package xufly.groundfire.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;
import xufly.groundfire.creative.GFCreativeTab;
import xufly.groundfire.fluid.FluidRegistry;

public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GroundFire.MODID);

	public static final RegistryObject<Item> mouse = ITEMS.register("mouse", ItemMouse::new);
	public static RegistryObject<Item> coalGasBucket = ITEMS.register("coal_gas_bucket", () -> new BucketItem(FluidRegistry.coalGasSource, new Item.Properties().tab(GFCreativeTab.GF_TAB).craftRemainder(Items.BUCKET)));

}
