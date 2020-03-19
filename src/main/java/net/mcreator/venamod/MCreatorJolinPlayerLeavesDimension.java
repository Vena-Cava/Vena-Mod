package net.mcreator.venamod;

import net.minecraft.world.World;

@Elementsvenamod.ModElement.Tag
public class MCreatorJolinPlayerLeavesDimension extends Elementsvenamod.ModElement {
	public MCreatorJolinPlayerLeavesDimension(Elementsvenamod instance) {
		super(instance, 72);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorJolinPlayerLeavesDimension!");
			return;
		}
		World world = (World) dependencies.get("world");
		venamodVariables.MapVariables.get(world).Heat = (double) 10;
		venamodVariables.MapVariables.get(world).syncData(world);
	}
}
