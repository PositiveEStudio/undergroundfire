package xufly.groundfire.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;

public class FluidRegistry
{
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, GroundFire.MODID);

	private static final ResourceLocation FLUID_STILL = new ResourceLocation("block/water_still");
	private static final ResourceLocation FLUID_FLOWING = new ResourceLocation("block/water_flow");

	public static final RegistryObject<FlowingFluid> coalGasSource = FLUIDS.register("coal_gas", () -> new ForgeFlowingFluid.Source(FluidRegistry.coalGasProperties));
	public static final RegistryObject<FlowingFluid> coalGasFlow = FLUIDS.register("coal_gas_flow", () -> new ForgeFlowingFluid.Flowing(FluidRegistry.coalGasProperties));

	public static final ForgeFlowingFluid.Properties coalGasProperties = new ForgeFlowingFluid.Properties(coalGasSource, coalGasFlow, FluidAttributes.builder(FLUID_STILL, FLUID_FLOWING).color(0xaaaaaaaa).density(-100).viscosity(500).luminosity(0).temperature(20).gaseous()).explosionResistance(100F).slopeFindDistance(5);
}
