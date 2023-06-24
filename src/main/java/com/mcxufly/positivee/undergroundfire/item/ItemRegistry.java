package com.mcxufly.positivee.undergroundfire.item;

import com.mcxufly.positivee.undergroundfire.UndergroundFire;
import com.mcxufly.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UndergroundFire.MODID);

	public static final RegistryObject<Item> MOUSE = ITEMS.register("mouse", ItemMouse::new);

	public static final RegistryObject<BlockItem> RICH_COAL_ORE = ITEMS.register("rich_coal_ore", () -> new BlockItem(BlockRegistry.RICH_COAL_ORE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> BURNING_RICH_COAL_ORE = ITEMS.register("burning_rich_coal_ore", () -> new BlockItem(BlockRegistry.BURNING_RICH_COAL_ORE.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> GAS_TANK = ITEMS.register("gas_tank", () -> new BlockItem(BlockRegistry.GAS_TANK.get(), new Item.Properties()));
	public static final RegistryObject<BlockItem> GAS_COAL = ITEMS.register("gas_coal", () -> new BlockItem(BlockRegistry.GAS_COAL.get(), new Item.Properties()));
}
