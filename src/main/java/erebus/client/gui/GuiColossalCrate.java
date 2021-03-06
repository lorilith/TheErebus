package erebus.client.gui;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import erebus.Erebus;
import erebus.client.gui.elements.GuiInvisibleButton;
import erebus.inventory.ContainerColossalCrate;
import erebus.network.server.ColossalCratePage;
import erebus.tileentity.TileEntityBambooCrate;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiColossalCrate extends GuiContainer {

	//public static final boolean hasInventoryTweaks = Loader.isModLoaded("inventorytweaks");
	private static final ResourceLocation GUI_BAMBOO_CRATE = new ResourceLocation("erebus:textures/gui/container/bamboo_collosal_crate.png");

	public GuiColossalCrate(InventoryPlayer playerInventory, List<TileEntityBambooCrate> list) {
		super(new ContainerColossalCrate(playerInventory, list));
		allowUserInput = false;
		ySize = 220;
		xSize = 230;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void initGui() {
		super.initGui();
		Keyboard.enableRepeatEvents(true);
		buttonList.clear();
		buttonList.add(new GuiInvisibleButton(0, guiLeft + 7, guiTop + 4, 17, 11));
		buttonList.add(new GuiInvisibleButton(1, guiLeft + 205, guiTop + 4, 17, 11));
		//This never worked!
		//buttonList.add(new GuiInvisibleButton(1, guiLeft + 205 - (hasInventoryTweaks ? 50 : 0), guiTop + 4, 17, 11));
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	public int getPageNumber() {
		return ((ContainerColossalCrate) inventorySlots).page;
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.enabled) {
			int newPage = 1;
			switch (button.id) {
				case 0:
					newPage = getPageNumber() - 1;
					Erebus.NETWORK_WRAPPER.sendToServer(new ColossalCratePage(newPage));
					((ContainerColossalCrate) inventorySlots).changePage(newPage);
					break;
				case 1:
					newPage = getPageNumber() + 1;
					Erebus.NETWORK_WRAPPER.sendToServer(new ColossalCratePage(newPage));
					((ContainerColossalCrate) inventorySlots).changePage(newPage);
					break;
			}
		}
	}

	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRenderer.drawString(I18n.format(new TextComponentTranslation("container.colossalCrate").getFormattedText()), 28, 6, 4210752);
		String str = getPageNumber() + "/3";
		fontRenderer.drawString(str, xSize / 2 - fontRenderer.getStringWidth(str) / 2, 6, 4210752);
		fontRenderer.drawString(I18n.format(new TextComponentTranslation("container.inventory").getFormattedText()), 32, ySize - 96 + 3, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(GUI_BAMBOO_CRATE);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
}