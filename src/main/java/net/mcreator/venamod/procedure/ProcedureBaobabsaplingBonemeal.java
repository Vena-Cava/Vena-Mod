package net.mcreator.venamod.procedure;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

import net.mcreator.venamod.block.BlockBaobabwood;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class ProcedureBaobabsaplingBonemeal extends ElementsVenaMod.ModElement {
	public ProcedureBaobabsaplingBonemeal(ElementsVenaMod instance) {
		super(instance, 49);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BaobabsaplingBonemeal!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BaobabsaplingBonemeal!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BaobabsaplingBonemeal!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BaobabsaplingBonemeal!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BaobabsaplingBonemeal!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.DYE, (int) (1), 15).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Items.DYE, (int) (1), 15).getItem(), 15, (int) 1, null);
			if ((Math.random() > 0.9085)) {
				if (!world.isRemote) {
					Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
							new ResourceLocation("venamod", "baobab-tree-1"));
					if (template != null) {
						BlockPos spawnTo = new BlockPos((int) (x + 9), (int) y, (int) (z + 11));
						IBlockState iblockstate = world.getBlockState(spawnTo);
						world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
						template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE)
								.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
					}
				}
				world.setBlockState(new BlockPos((int) (x + 9), (int) y, (int) (z + 11)), BlockBaobabwood.block.getDefaultState(), 3);
			}
		}
	}
}
