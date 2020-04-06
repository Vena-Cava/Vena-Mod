
package net.mcreator.venamod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.venamod.block.BlockPalmwood;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class RecipePalmcharcoal extends ElementsVenaMod.ModElement {
	public RecipePalmcharcoal(ElementsVenaMod instance) {
		super(instance, 55);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockPalmwood.block, (int) (1)), new ItemStack(Items.COAL, (int) (0), 1), 0F);
	}
}
