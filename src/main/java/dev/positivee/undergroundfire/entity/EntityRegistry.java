package dev.positivee.undergroundfire.entity;

import dev.positivee.undergroundfire.UndergroundFire;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UndergroundFire.MODID);

	public static final RegistryObject<EntityType<EntityMouse>> MOUSE = ENTITY_TYPE.register("mouse",
			() -> EntityType.Builder.of(EntityMouse::new, MobCategory.MISC)
					.sized(0.25F, 0.25F).clientTrackingRange(16).updateInterval(10)
					.build(new ResourceLocation(UndergroundFire.MODID, "mouse").toString()));
}
