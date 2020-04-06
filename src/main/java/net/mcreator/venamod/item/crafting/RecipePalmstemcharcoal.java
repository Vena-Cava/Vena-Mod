
package net.mcreator.venamod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.venamod.block.BlockPalmstem;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class RecipePalmstemcharcoal extends ElementsVenaMod.ModElement {
	public RecipePalmstemcharcoal(ElementsVenaMod instance) {
		super(instance, 56);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockPalmstem.block, (int) (1)), new ItemStack(Items.COAL, (int) (0), 1), 0F);
	}
}
