package net.mcreator.venamod;

import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;

@Elementsvenamod.ModElement.Tag
public class MCreatorTickCounter extends Elementsvenamod.ModElement {
	public MCreatorTickCounter(Elementsvenamod instance) {
		super(instance, 71);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTickCounter!");
			return;
		}
		World world = (World) dependencies.get("world");
		venamodVariables.WorldVariables.get(world).TickCount = (double) ((venamodVariables.WorldVariables.get(world).TickCount) + 1);
		venamodVariables.WorldVariables.get(world).syncData(world);
		if (((venamodVariables.WorldVariables.get(world).TickCount) == 121)) {
			venamodVariables.WorldVariables.get(world).TickCount = (double) 1;
			venamodVariables.WorldVariables.get(world).syncData(world);
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
