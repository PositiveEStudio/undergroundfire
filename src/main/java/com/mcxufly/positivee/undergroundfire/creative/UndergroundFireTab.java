package com.mcxufly.positivee.undergroundfire.creative;

import com.mcxufly.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class UndergroundFireTab extends CreativeModeTab
{
	public UndergroundFireTab()
	{
		super("undergroundfire_tab");
	}

	@Override
	public @NotNull ItemStack makeIcon()
	{
		return new ItemStack(ItemRegistry.mouse.get());
	}
}
