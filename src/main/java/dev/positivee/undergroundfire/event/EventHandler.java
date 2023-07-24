package dev.positivee.undergroundfire.event;

import dev.positivee.undergroundfire.UndergroundFire;
import dev.positivee.undergroundfire.entity.EntityMouse;
import dev.positivee.undergroundfire.entity.EntityRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UndergroundFire.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler
{
	@SubscribeEvent
	public static void addEntityAttributes(EntityAttributeCreationEvent event)
	{
		event.put(EntityRegistry.MOUSE.get(), EntityMouse.createAttributes().build());
	}
}
