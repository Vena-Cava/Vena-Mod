package net.mcreator.venamod.procedure;

import net.minecraft.world.World;

import net.mcreator.venamod.VenaModVariables;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class ProcedureJolinPlayerLeavesDimension extends ElementsVenaMod.ModElement {
	public ProcedureJolinPlayerLeavesDimension(ElementsVenaMod instance) {
		super(instance, 80);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure JolinPlayerLeavesDimension!");
			return;
		}
		World world = (World) dependencies.get("world");
		VenaModVariables.MapVariables.get(world).Heat = (double) 10;
		VenaModVariables.MapVariables.get(world).syncData(world);
	}
}
