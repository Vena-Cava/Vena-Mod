package net.mcreator.venamod.procedure;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.venamod.world.WorldJolin;
import net.mcreator.venamod.VenaModVariables;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class ProcedureTemperatureDeath extends ElementsVenaMod.ModElement {
	public ProcedureTemperatureDeath(ElementsVenaMod instance) {
		super(instance, 78);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TemperatureDeath!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TemperatureDeath!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((((WorldJolin.DIMID) == (world.provider.getDimension())) && (((VenaModVariables.MapVariables.get(world).Insulated) == (false))
				&& (((VenaModVariables.MapVariables.get(world).Antifreeze) == (false))
						&& (((VenaModVariables.WorldVariables.get(world).TickCount) == 120)
								&& ((((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false) == (false))
										&& (((VenaModVariables.Player_Dead) == (false))
												&& ((VenaModVariables.MapVariables.get(world).Heat) > 0)))))))) {
			VenaModVariables.MapVariables.get(world).Heat = (double) ((VenaModVariables.MapVariables.get(world).Heat) - 0.5);
			VenaModVariables.MapVariables.get(world).syncData(world);
		}
		if ((((WorldJolin.DIMID) == (world.provider.getDimension())) && (((VenaModVariables.MapVariables.get(world).Insulated) == (false))
				&& (((VenaModVariables.MapVariables.get(world).Antifreeze) == (false)) && (((((entity instanceof EntityPlayer)
						? ((EntityPlayer) entity).capabilities.isCreativeMode
						: false) == (false))
						&& (((VenaModVariables.MapVariables.get(world).Heat) <= 0)
								&& (((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) > 0)))
						&& (((VenaModVariables.Player_Dead) == (false)) && (((VenaModVariables.WorldVariables.get(world).TickCount) == 10)
								|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 20) || (((VenaModVariables.WorldVariables
										.get(world).TickCount) == 30)
										|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 40) || (((VenaModVariables.WorldVariables
												.get(world).TickCount) == 50)
												|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 60)
														|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 70)
																|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 80)
																		|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 90)
																				|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 100)
																						|| (((VenaModVariables.WorldVariables
																								.get(world).TickCount) == 110)
																								|| ((VenaModVariables.WorldVariables.get(
																										world).TickCount) == 120)))))))))))))))))) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity)
						.setHealth((float) (((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) - 1));
			if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) < 0.5)) {
				VenaModVariables.Player_Dead = (boolean) (true);
			}
		}
		if (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) <= 0)
				&& ((VenaModVariables.Player_Dead) == (true)))) {
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(
							new TextComponentString((((entity.getDisplayName().getFormattedText())) + "" + (" couldn't take the cold"))));
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.posX;
			int j = (int) entity.posY;
			int k = (int) entity.posZ;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
