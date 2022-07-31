package xufly.groundfire.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import xufly.groundfire.GroundFire;
import xufly.groundfire.block.entity.BlockEntityExtractor;
import xufly.groundfire.client.gui.menu.MenuExtractor;

public class ScreenExtractor extends AbstractContainerScreen<MenuExtractor>
{
	private static final ResourceLocation gui = new ResourceLocation(GroundFire.MODID, "textures/gui/extractor.png");
	private final BlockEntityExtractor blockEntity;

	public ScreenExtractor(MenuExtractor menu, Inventory playerInv, Component title)
	{
		super(menu, playerInv, title);
		blockEntity = menu.getEntity();
	}

	@Override
	protected void init()
	{
		super.init();
	}

	@Override
	public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick)
	{
		super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
		RenderSystem.setShaderTexture(0, gui);
	}

	@Override
	protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY)
	{
		renderBackground(pPoseStack);
		RenderSystem.setShaderTexture(0, gui);
	}

	@Override
	protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY)
	{
		font.draw(pPoseStack, title, titleLabelX, titleLabelY, 4210752);
		font.draw(pPoseStack, playerInventoryTitle, inventoryLabelX, inventoryLabelY + 28, 4210752);
	}
}
