package xufly.groundfire.creative;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import xufly.groundfire.item.ItemRegistryHandler;

public class GroundFireTab extends CreativeModeTab
{
	public GroundFireTab()
	{
		super("groundfire_tab");
	}

	@Override
	public ItemStack makeIcon()
	{
		return new ItemStack(ItemRegistryHandler.MOUSE.get());
	}
}
