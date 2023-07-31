package dev.positivee.undergroundfire.gui.menu;

import dev.positivee.undergroundfire.block.BlockRegistry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class MenuGasCoalExtractor extends AbstractContainerMenu
{
	public MenuGasCoalExtractor(int pContainerId, Inventory playerInv)
	{
		super(MenuRegistry.GAS_COAL_EXTRACTOR.get(), pContainerId);
	}

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex)
	{
		return null;
	}

	@Override
	public boolean stillValid(Player pPlayer)
	{
		return true;
	}
}
