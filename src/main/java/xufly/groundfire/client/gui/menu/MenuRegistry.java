package xufly.groundfire.client.gui.menu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;

public class MenuRegistry
{
	public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(ForgeRegistries.CONTAINERS, GroundFire.MODID);
	public static final RegistryObject<MenuType<MenuExtractor>> menuExtractor = MENU.register("extractor", () -> IForgeMenuType.create(MenuExtractor::new));
}
