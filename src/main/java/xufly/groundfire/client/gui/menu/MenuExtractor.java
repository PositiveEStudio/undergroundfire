package xufly.groundfire.client.gui.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.phys.Vec3;
import xufly.groundfire.block.entity.BlockEntityExtractor;

public class MenuExtractor extends AbstractContainerMenu
{
	private final BlockEntityExtractor blockEntity;

	public MenuExtractor(int id, Inventory playerInv, BlockPos pos)
	{
		super(MenuRegistry.menuExtractor.get(), id);
		blockEntity = (BlockEntityExtractor) playerInv.player.level.getBlockEntity(pos);
	}

	public MenuExtractor(int id, Inventory playerInv, FriendlyByteBuf buf)
	{
		this(id, playerInv, buf.readBlockPos());
	}

	@Override
	public boolean stillValid(Player player)
	{
		return blockEntity.getLevel() == player.getLevel() && player.position().distanceTo(Vec3.atCenterOf(blockEntity.getBlockPos()).add(0.5, 0.5, 0.5)) < 6;
	}

	public BlockEntityExtractor getEntity()
	{
		return blockEntity;
	}
}
