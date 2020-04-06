package net.mcreator.venamod.procedure;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;

import net.mcreator.venamod.VenaModVariables;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class ProcedureTickCounter extends ElementsVenaMod.ModElement {
	public ProcedureTickCounter(ElementsVenaMod instance) {
		super(instance, 79);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TickCounter!");
			return;
		}
		World world = (World) dependencies.get("world");
		VenaModVariables.WorldVariables.get(world).TickCount = (double) ((VenaModVariables.WorldVariables.get(world).TickCount) + 1);
		VenaModVariables.WorldVariables.get(world).syncData(world);
		if (((VenaModVariables.WorldVariables.get(world).TickCount) == 121)) {
			VenaModVariables.WorldVariables.get(world).TickCount = (double) 1;
			VenaModVariables.WorldVariables.get(world).syncData(world);
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			World world = event.world;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
