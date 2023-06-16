package com.mcxufly.positivee.undergroundfire.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.mcxufly.positivee.undergroundfire.UndergroundFire;
import com.mcxufly.positivee.undergroundfire.block.BlockRegistry;
import com.mcxufly.positivee.undergroundfire.creative.UGFCreativeTab;

public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UndergroundFire.MODID);

	public static final RegistryObject<Item> mouse = ITEMS.register("mouse", ItemMouse::new);

	public static final RegistryObject<BlockItem> richCoalOre = ITEMS.register("rich_coal_ore", () -> new BlockItem(BlockRegistry.richCoalOre.get(), new Item.Properties().tab(UGFCreativeTab.GF_TAB)));
	public static final RegistryObject<BlockItem> burningRichCoalOre = ITEMS.register("burning_rich_coal_ore", () -> new BlockItem(BlockRegistry.burningRichCoalOre.get(), new Item.Properties().tab(UGFCreativeTab.GF_TAB)));
	public static final RegistryObject<BlockItem> gasTank = ITEMS.register("gas_tank", () -> new BlockItem(BlockRegistry.gasTank.get(), new Item.Properties().tab(UGFCreativeTab.GF_TAB)));
	public static final RegistryObject<BlockItem> gasCoal = ITEMS.register("gas_coal", () -> new BlockItem(BlockRegistry.gasCoal.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> extractor = ITEMS.register("extractor", () -> new BlockItem(BlockRegistry.extractor.get(), new Item.Properties().tab(UGFCreativeTab.GF_TAB)));
}
