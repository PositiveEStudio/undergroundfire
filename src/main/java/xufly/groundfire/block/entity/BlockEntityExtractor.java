package xufly.groundfire.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xufly.groundfire.menu.MenuExtractor;

public class BlockEntityExtractor extends BlockEntity implements MenuProvider
{
	public BlockEntityExtractor(BlockPos pos, BlockState state)
	{
		super(BlockEntityRegistry.blockEntityExtractor.get(), pos, state);
	}

	public static <T extends BlockEntity> void tick(Level world, BlockPos pos, BlockState State, BlockEntityExtractor entity)
	{
	}

	@Override
	public Component getDisplayName()
	{
		return new TranslatableComponent("title.groundfire.extractor.main");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInv, @NotNull Player player)
	{
		return new MenuExtractor(id, playerInv, getBlockPos());
	}
}
