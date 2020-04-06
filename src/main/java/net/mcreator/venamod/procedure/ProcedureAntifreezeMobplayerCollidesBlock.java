package net.mcreator.venamod.procedure;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.venamod.VenaModVariables;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class ProcedureAntifreezeMobplayerCollidesBlock extends ElementsVenaMod.ModElement {
	public ProcedureAntifreezeMobplayerCollidesBlock(ElementsVenaMod instance) {
		super(instance, 65);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AntifreezeMobplayerCollidesBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AntifreezeMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((!(entity instanceof EntityPlayer))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 3);
		}
		if ((((VenaModVariables.MapVariables.get(world).Heat) > 0) && ((entity instanceof EntityPlayer)
				&& (((VenaModVariables.WorldVariables.get(world).TickCount) == 20) || (((VenaModVariables.WorldVariables.get(world).TickCount) == 40)
						|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 60)
								|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 80)
										|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 100)
												|| ((VenaModVariables.WorldVariables.get(world).TickCount) == 120))))))))) {
			VenaModVariables.MapVariables.get(world).Antifreeze = (boolean) (true);
			VenaModVariables.MapVariables.get(world).syncData(world);
			VenaModVariables.MapVariables.get(world).Heat = (double) ((VenaModVariables.MapVariables.get(world).Heat) - 1);
			VenaModVariables.MapVariables.get(world).syncData(world);
		}
		if ((((VenaModVariables.MapVariables.get(world).Heat) == 0)
				&& ((entity instanceof EntityPlayer) && (((VenaModVariables.MapVariables.get(world).Antifreeze) == (true))
						&& (((VenaModVariables.WorldVariables.get(world).TickCount) == 20)
								|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 40)
										|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 60)
												|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 80)
														|| (((VenaModVariables.WorldVariables.get(world).TickCount) == 100)
																|| ((VenaModVariables.WorldVariables.get(world).TickCount) == 120)))))))))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 3);
		}
	}
}
