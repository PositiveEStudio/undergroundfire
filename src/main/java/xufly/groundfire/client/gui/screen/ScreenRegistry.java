package xufly.groundfire.client.gui.screen;

import net.minecraft.client.gui.screens.MenuScreens;
import xufly.groundfire.client.gui.menu.MenuRegistry;

public class ScreenRegistry
{
	public static void register()
	{
		MenuScreens.register(MenuRegistry.menuExtractor.get(), ScreenExtractor::new);
	}
}
