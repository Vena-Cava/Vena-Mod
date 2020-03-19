package net.mcreator.venamod;

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

@Elementsvenamod.ModElement.Tag
public class MCreatorTemperatureDeath extends Elementsvenamod.ModElement {
	public MCreatorTemperatureDeath(Elementsvenamod instance) {
		super(instance, 70);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorTemperatureDeath!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTemperatureDeath!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((((MCreatorJolin.DIMID) == (world.provider.getDimension())) && (((venamodVariables.MapVariables.get(world).Insulated) == (false)) && (((venamodVariables.MapVariables
				.get(world).Antifreeze) == (false)) && (((venamodVariables.WorldVariables.get(world).TickCount) == 120) && ((((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).capabilities.isCreativeMode
				: false) == (false)) && ((venamodVariables.MapVariables.get(world).Heat) > 0))))))) {
			venamodVariables.MapVariables.get(world).Heat = (double) ((venamodVariables.MapVariables.get(world).Heat) - 0.5);
			venamodVariables.MapVariables.get(world).syncData(world);
		}
		if ((((MCreatorJolin.DIMID) == (world.provider.getDimension())) && (((venamodVariables.MapVariables.get(world).Insulated) == (false)) && (((venamodVariables.MapVariables
				.get(world).Antifreeze) == (false)) && (((((entity instanceof EntityPlayer)
				? ((EntityPlayer) entity).capabilities.isCreativeMode
				: false) == (false)) && (((venamodVariables.MapVariables.get(world).Heat) <= 0) && (((entity instanceof EntityLivingBase)
				? ((EntityLivingBase) entity).getHealth()
				: -1) > 0))) && (((venamodVariables.WorldVariables.get(world).TickCount) == 30) || (((venamodVariables.WorldVariables.get(world).TickCount) == 60) || (((venamodVariables.WorldVariables
				.get(world).TickCount) == 90) || ((venamodVariables.WorldVariables.get(world).TickCount) == 120))))))))) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity)
						.setHealth((float) (((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) - 2));
			if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) <= 0)) {
				venamodVariables.Player_Dead = (boolean) (true);
			}
		}
		if (((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) <= 0) && ((venamodVariables.Player_Dead) == (true)))) {
			{
				MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(
							new TextComponentString((((entity.getDisplayName().getFormattedText())) + "" + (" couldn't take the cold"))));
			}
			venamodVariables.Player_Dead = (boolean) (false);
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
