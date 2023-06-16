package com.mcxufly.positivee.undergroundfire.client.gui.menu;

import com.google.common.collect.ImmutableList;
import com.mcxufly.positivee.undergroundfire.block.entity.BlockEntityExtractor;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.SlotItemHandler;

public class MenuExtractor extends AbstractContainerMenu
{
	private final BlockEntityExtractor blockEntity;
	private final ImmutableList<Slot> tankSlot;

	public MenuExtractor(int id, Inventory playerInv, BlockPos pos)
	{
		super(MenuRegistry.menuExtractor.get(), id);
		blockEntity = (BlockEntityExtractor) playerInv.player.level.getBlockEntity(pos);
		buildPlayerInvSlot(playerInv);
		tankSlot = buildTankInvSlot();
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

	private void buildPlayerInvSlot(Inventory playerInv)
	{

		for (int l = 0; l < 3; ++l)
		{
			for (int k = 0; k < 9; ++k)
			{
				this.addSlot(new Slot(playerInv, k + l * 9 + 9, 8 + k * 18, l * 18 + 51));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1)
		{
			this.addSlot(new Slot(playerInv, i1, 8 + i1 * 18, 109));
		}

	}

	private ImmutableList<Slot> buildTankInvSlot()
	{
		ImmutableList.Builder<Slot> builder = ImmutableList.builder();
		SlotItemHandler slot = new SlotItemHandler(blockEntity.getTank(), 0, 134, 20);
		this.addSlot(slot);
		builder.add(slot);
		return builder.build();
	}
}
