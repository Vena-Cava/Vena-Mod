
package net.mcreator.venamod.gui.overlay;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

import net.mcreator.venamod.world.WorldJolin;
import net.mcreator.venamod.VenaModVariables;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class OverlaySnowflake_Point3 extends ElementsVenaMod.ModElement {
	public OverlaySnowflake_Point3(ElementsVenaMod instance) {
		super(instance, 70);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GUIRenderEventClass());
	}
	public static class GUIRenderEventClass {
		@SubscribeEvent(priority = EventPriority.NORMAL)
		@SideOnly(Side.CLIENT)
		public void eventHandler(RenderGameOverlayEvent event) {
			if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
				int posX = (event.getResolution().getScaledWidth()) / 2;
				int posY = (event.getResolution().getScaledHeight()) / 2;
				EntityPlayer entity = Minecraft.getMinecraft().player;
				World world = entity.world;
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				if (((((entity.dimension) == (WorldJolin.DIMID))
						&& (!((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false)))
						&& ((VenaModVariables.MapVariables.get(world).Heat) >= 3))) {
					GlStateManager.disableDepth();
					GlStateManager.depthMask(false);
					GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
							GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
					GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
					GlStateManager.disableAlpha();
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("venamod:textures/snowflake.png"));
					Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(posX + 67, posY + 70, 0, 0, 256, 256);
					GlStateManager.depthMask(true);
					GlStateManager.enableDepth();
					GlStateManager.enableAlpha();
					GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				}
			}
		}
	}
}
