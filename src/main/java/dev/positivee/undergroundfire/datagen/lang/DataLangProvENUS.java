package dev.positivee.undergroundfire.datagen.lang;

import dev.positivee.undergroundfire.block.BlockRegistry;
import dev.positivee.undergroundfire.entity.EntityRegistry;
import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class DataLangProvENUS extends LanguageProvider
{
	public DataLangProvENUS(PackOutput output, String modid)
	{
		super(output, modid, "en_us");
	}

	@Override
	protected void addTranslations()
	{
		this.add("itemGroup.undergroundfire", "Underground Fire");

		this.add(ItemRegistry.MOUSE.get(), "Mouse");

		this.add(BlockRegistry.RICH_COAL_ORE.get(),"Rich Coal Ore");
		this.add(BlockRegistry.BURNING_RICH_COAL_ORE.get(), "Burning Rich Coal Ore");
		this.add(BlockRegistry.GAS_COAL.get(), "Gas Coal");
		this.add(BlockRegistry.GAS_TANK.get(), "Gas Tank");
		this.add(BlockRegistry.GAS_COAL_EXTRACTOR.get(),"Gas Coal Exacter");

		this.add(EntityRegistry.MOUSE.get(), "Mouse");
	}
}
