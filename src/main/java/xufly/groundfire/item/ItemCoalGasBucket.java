package xufly.groundfire.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import xufly.groundfire.creative.GFCreativeTab;
import xufly.groundfire.fluid.FluidRegistry;

public class ItemCoalGasBucket extends BucketItem
{
	public ItemCoalGasBucket()
	{
		super(FluidRegistry.coalGasSource, (new Item.Properties()).tab(GFCreativeTab.GF_TAB));
	}
}
