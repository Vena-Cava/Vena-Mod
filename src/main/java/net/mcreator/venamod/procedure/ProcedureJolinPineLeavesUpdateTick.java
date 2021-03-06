package net.mcreator.venamod.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

import net.mcreator.venamod.world.WorldJolin;
import net.mcreator.venamod.block.BlockSnowyPineLeaves;
import net.mcreator.venamod.block.BlockPineLeaves;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class ProcedureJolinPineLeavesUpdateTick extends ElementsVenaMod.ModElement {
	public ProcedureJolinPineLeavesUpdateTick(ElementsVenaMod instance) {
		super(instance, 84);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure JolinPineLeavesUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure JolinPineLeavesUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure JolinPineLeavesUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure JolinPineLeavesUpdateTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.provider.getDimension()) == (0))) {
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockPineLeaves.block.getDefaultState(), 3);
		} else if ((((world.provider.getDimension()) == (WorldJolin.DIMID))
				&& ((world.isRaining()) && (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.AIR
						.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.SNOW_LAYER
								.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.SNOW
										.getDefaultState().getBlock())))))) {
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockSnowyPineLeaves.block.getDefaultState(), 3);
		}
	}
}
