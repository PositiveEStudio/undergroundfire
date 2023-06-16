package com.mcxufly.positivee.undergroundfire.client.gui.screen;

import net.minecraft.client.gui.screens.MenuScreens;
import com.mcxufly.positivee.undergroundfire.client.gui.menu.MenuRegistry;

public class ScreenRegistry
{
	public static void register()
	{
		MenuScreens.register(MenuRegistry.menuExtractor.get(), ScreenExtractor::new);
	}
}
