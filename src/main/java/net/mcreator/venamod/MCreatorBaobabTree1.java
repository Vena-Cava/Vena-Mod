package net.mcreator.venamod;

import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;

import java.util.Random;

@Elementsvenamod.ModElement.Tag
public class MCreatorBaobabTree1 extends Elementsvenamod.ModElement {
	public MCreatorBaobabTree1(Elementsvenamod instance) {
		super(instance, 5);
	}

	@Override
	public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		boolean isNetherType = false;
		if (dimID == 0)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		if ((random.nextInt(1000000) + 1) <= 10000) {
			int i = i2 + random.nextInt(16) + 8;
			int k = k2 + random.nextInt(16) + 8;
			int height = 255;
			if (isNetherType) {
				boolean notpassed = true;
				while (height > 0) {
					if (notpassed
							&& (world.isAirBlock(new BlockPos(i, height, k)) || !world.getBlockState(new BlockPos(i, height, k)).getBlock()
									.getMaterial(world.getBlockState(new BlockPos(i, height, k))).blocksMovement()))
						notpassed = false;
					else if (!notpassed
							&& !world.isAirBlock(new BlockPos(i, height, k))
							&& world.getBlockState(new BlockPos(i, height, k)).getBlock()
									.getMaterial(world.getBlockState(new BlockPos(i, height, k))).blocksMovement())
						break;
					height--;
				}
			} else {
				while (height > 0) {
					if (!world.isAirBlock(new BlockPos(i, height, k))
							&& world.getBlockState(new BlockPos(i, height, k)).getBlock()
									.getMaterial(world.getBlockState(new BlockPos(i, height, k))).blocksMovement())
						break;
					height--;
				}
			}
			int j = height - 1;
			IBlockState blockAt = world.getBlockState(new BlockPos(i, j + 1, k));
			boolean blockCriteria = false;
			IBlockState require;
			require = Blocks.GRASS.getDefaultState();
			if (blockAt.getBlock() == require.getBlock())
				blockCriteria = true;
			if (!blockCriteria)
				return;
			boolean biomeCriteria = false;
			Biome biome = world.getBiome(new BlockPos(i, j, k));
			if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("venamod:wetsavanna")))
				biomeCriteria = true;
			if (Biome.REGISTRY.getNameForObject(biome).equals(new ResourceLocation("savanna")))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			if (world.isRemote)
				return;
			Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),
					new ResourceLocation("venamod", "baobab-tree-1"));
			if (template == null)
				return;
			Rotation rotation = Rotation.values()[random.nextInt(3)];
			Mirror mirror = Mirror.values()[random.nextInt(2)];
			BlockPos spawnTo = new BlockPos(i, j + 0, k);
			IBlockState iblockstate = world.getBlockState(spawnTo);
			world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
			template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(rotation).setMirror(mirror).setChunk((ChunkPos) null)
					.setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
		}
	}
}
