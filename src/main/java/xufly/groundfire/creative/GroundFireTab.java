package xufly.groundfire.creative;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import xufly.groundfire.item.ItemRegistry;

public class GroundFireTab extends CreativeModeTab
{
	public GroundFireTab()
	{
		super("groundfire_tab");
	}

	@Override
	public @NotNull ItemStack makeIcon()
	{
		return new ItemStack(ItemRegistry.mouse.get());
	}
}
