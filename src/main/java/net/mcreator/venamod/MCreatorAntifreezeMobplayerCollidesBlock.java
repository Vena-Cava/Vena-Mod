package net.mcreator.venamod;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@Elementsvenamod.ModElement.Tag
public class MCreatorAntifreezeMobplayerCollidesBlock extends Elementsvenamod.ModElement {
	public MCreatorAntifreezeMobplayerCollidesBlock(Elementsvenamod instance) {
		super(instance, 57);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorAntifreezeMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) == 0)) {
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				MCreatorAntifreezeKill.executeProcedure($_dependencies);
			}
			entity.world.removeEntity(entity);
		}
	}
}
