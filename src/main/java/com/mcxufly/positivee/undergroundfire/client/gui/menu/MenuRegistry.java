package com.mcxufly.positivee.undergroundfire.client.gui.menu;

import com.mcxufly.positivee.undergroundfire.UndergroundFire;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuRegistry
{
	public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(ForgeRegistries.CONTAINERS, UndergroundFire.MODID);
	public static final RegistryObject<MenuType<MenuExtractor>> menuExtractor = MENU.register("extractor", () -> IForgeMenuType.create(MenuExtractor::new));
}
