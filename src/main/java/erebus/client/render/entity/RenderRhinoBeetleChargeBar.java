package erebus.client.render.entity;

import erebus.entity.EntityRhinoBeetle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRhinoBeetleChargeBar extends Gui {

	@SubscribeEvent
	public void onRenderHUD(RenderGameOverlayEvent.Post event) {
		Minecraft mc = Minecraft.getMinecraft();
		if (event.getType().equals(RenderGameOverlayEvent.ElementType.HOTBAR)) {
			EntityPlayerSP player = mc.player;
			if (player != null && player.getRidingEntity() != null && player.getRidingEntity() instanceof EntityRhinoBeetle) {
				GlStateManager.color(1F, 1F, 1F, 1F);
				mc.renderEngine.bindTexture(new ResourceLocation("erebus:textures/gui/overlay/rhino_charge_bar.png"));
				ScaledResolution res = new ScaledResolution(mc);
				renderChargeBar(((EntityRhinoBeetle) player.getRidingEntity()).getRammingCharge() * 2, res.getScaledWidth() / 2 - 90, res.getScaledHeight() - 30);
			}
		}
	}

	private void renderChargeBar(int currCond, int posX, int posY) {
		for (int i = 0; i < currCond / 5; i++)
			drawTexturedModalRect(posX + i * 8, posY, 0, 0, 7, 1);
	}
}