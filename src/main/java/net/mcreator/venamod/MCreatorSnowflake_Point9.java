package net.mcreator.venamod;

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
import net.minecraft.client.Minecraft;

@Elementsvenamod.ModElement.Tag
public class MCreatorSnowflake_Point9 extends Elementsvenamod.ModElement {
	public MCreatorSnowflake_Point9(Elementsvenamod instance) {
		super(instance, 68);
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
				if (((((entity.dimension) == (MCreatorJolin.DIMID)) && (!((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).capabilities.isCreativeMode
						: false))) && ((venamodVariables.MapVariables.get(world).Heat) >= 9))) {
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("venamod:textures/snowflake.png"));
					Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(posX + 19, posY + 70, 0, 0, 256, 256);
				}
			}
		}
	}
}
