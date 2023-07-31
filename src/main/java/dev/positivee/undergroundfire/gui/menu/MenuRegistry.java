package dev.positivee.undergroundfire.gui.menu;

import dev.positivee.undergroundfire.UndergroundFire;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuRegistry
{
	public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(ForgeRegistries.MENU_TYPES, UndergroundFire.MODID);

	public static final RegistryObject<MenuType<MenuGasCoalExtractor>> GAS_COAL_EXTRACTOR = MENU_TYPE.register("menu_gas_coal_extractor", () -> new MenuType(MenuGasCoalExtractor::new, FeatureFlags.DEFAULT_FLAGS));
}
