package dev.positivee.undergroundfire.data;

import dev.positivee.undergroundfire.block.BlockRegistry;
import dev.positivee.undergroundfire.entity.EntityRegistry;
import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class DataLangProvZHCN extends LanguageProvider
{
	public DataLangProvZHCN(PackOutput output, String modid)
	{
		super(output, modid, "zh_cn");
	}

	@Override
	protected void addTranslations()
	{
		this.add("itemGroup.undergroundfire", "地火");

		this.add(ItemRegistry.MOUSE.get(), "耗子");

		this.add(BlockRegistry.RICH_COAL_ORE.get(),"富煤矿");
		this.add(BlockRegistry.BURNING_RICH_COAL_ORE.get(), "燃烧的富煤矿");
		this.add(BlockRegistry.GAS_COAL.get(), "气化煤");
		this.add(BlockRegistry.GAS_TANK.get(), "煤气罐");

		this.add(EntityRegistry.MOUSE.get(), "耗子");
	}
}
