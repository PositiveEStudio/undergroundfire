package xufly.groundfire.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class FluidCoalGas extends ForgeFlowingFluid
{
	private static final Properties properties = new Properties(FluidRegistry.coalGasSource, FluidRegistry.coalGasFlow, FluidAttributes.builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow")).gaseous().color(0x44aaaaaa));

	public FluidCoalGas()
	{
		super(properties);
	}

	public static Source source()
	{
		return new Source(properties);
	}

	public static Flowing flowing()
	{
		return new Flowing(properties);
	}
}
