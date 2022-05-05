package xufly.groundfire.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;

public class ItemRegistryHandler
{
	public static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, GroundFire.MODID);

	public static final RegistryObject<Item> MOUSE = ITEM_REGISTER.register("mouse", ItemMouse::new);
}
