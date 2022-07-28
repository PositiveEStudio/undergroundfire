package xufly.groundfire.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import xufly.groundfire.GroundFire;
import xufly.groundfire.menu.MenuExtractor;

public class ScreenExtractor extends AbstractContainerScreen<MenuExtractor>
{
	private static final ResourceLocation gui = new ResourceLocation(GroundFire.MODID, "textures/gui/extractor.png");

	public ScreenExtractor(MenuExtractor menu, Inventory playerInv)
	{
		super(menu, playerInv, new TranslatableComponent("title.groundfire.extractor.main"));
	}

	@Override
	protected void renderBg(@NotNull PoseStack poseStack, float partialTick, int mouseX, int mouseY)
	{
		renderBackground(poseStack);
	}
}
