package xufly.groundfire.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xufly.groundfire.GroundFire;

public class FluidRegistry
{
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, GroundFire.MODID);

	public static final RegistryObject<FlowingFluid> coalGasSource = FLUIDS.register("coal_gas", FluidCoalGas::source);
	public static final RegistryObject<FlowingFluid> coalGasFlow = FLUIDS.register("coal_gas_flow", FluidCoalGas::flowing);
}
