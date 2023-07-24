package dev.positivee.undergroundfire.creative;

import dev.positivee.undergroundfire.UndergroundFire;
import dev.positivee.undergroundfire.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabRegistry
{
	public static final DeferredRegister<net.minecraft.world.item.CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UndergroundFire.MODID);
//	public static final RegistryObject<net.minecraft.world.item.CreativeModeTab> UNDERGROUNDFIRE = CREATIVE_MODE_TAB.register("undergroundfire", CreativeModeTabUndergroundfire::new);

	public static final RegistryObject<net.minecraft.world.item.CreativeModeTab> UNDERGROUNDFIRE = CREATIVE_MODE_TAB.register("undergroundfire", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.undergroundfire"))
			.icon(() -> ItemRegistry.MOUSE.get().getDefaultInstance())
			.withTabsBefore(new ResourceLocation("minecraft:spawn_eggs"))
			.displayItems((parameters, output) ->
			{
				output.accept(ItemRegistry.MOUSE.get());
				output.accept(ItemRegistry.RICH_COAL_ORE.get());
				output.accept(ItemRegistry.BURNING_RICH_COAL_ORE.get());
				output.accept(ItemRegistry.GAS_TANK.get());
				output.accept(ItemRegistry.GAS_COAL_EXTRACTOR.get());
			}).build());

}
