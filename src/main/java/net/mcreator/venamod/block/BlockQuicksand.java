
package net.mcreator.venamod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class BlockQuicksand extends ElementsVenaMod.ModElement {
	@GameRegistry.ObjectHolder("venamod:quicksand")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("venamod:quicksand")
	public static final Item item = null;
	private Fluid fluid;
	public BlockQuicksand(ElementsVenaMod instance) {
		super(instance, 21);
		fluid = new Fluid("quicksand", new ResourceLocation("venamod:blocks/quicksand"), new ResourceLocation("venamod:blocks/quicksand_flow"))
				.setLuminosity(0).setDensity(2000).setViscosity(10000).setGaseous(false);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.WATER) {
		}.setUnlocalizedName("quicksand").setRegistryName("quicksand"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("quicksand"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("venamod:quicksand", "quicksand");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("venamod:quicksand", "quicksand");
			}
		});
	}
}
