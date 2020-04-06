
package net.mcreator.venamod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.venamod.item.ItemCattailhead;
import net.mcreator.venamod.item.ItemBoiledcattailhead;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class RecipeBoiledcattail extends ElementsVenaMod.ModElement {
	public RecipeBoiledcattail(ElementsVenaMod instance) {
		super(instance, 45);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemCattailhead.block, (int) (1)), new ItemStack(ItemBoiledcattailhead.block, (int) (0)), 0F);
	}
}
