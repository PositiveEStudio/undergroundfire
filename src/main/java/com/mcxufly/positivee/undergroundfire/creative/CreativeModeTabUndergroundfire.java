package com.mcxufly.positivee.undergroundfire.creative;

import com.mcxufly.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class CreativeModeTabUndergroundfire extends CreativeModeTab
{
	public CreativeModeTabUndergroundfire()
	{
		super(CreativeModeTab.builder()
				.title(Component.translatable("itemGroup.undergroundfire"))
				.icon(() -> ItemRegistry.MOUSE.get().getDefaultInstance())
				.displayItems((parameters, output) ->
				{
					output.accept(ItemRegistry.MOUSE.get());
					output.accept(ItemRegistry.RICH_COAL_ORE.get());
					output.accept(ItemRegistry.BURNING_RICH_COAL_ORE.get());
					output.accept(ItemRegistry.GAS_TANK.get());
				})
		);

	}
}
