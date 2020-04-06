
package net.mcreator.venamod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.venamod.block.BlockBaobabwood;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class RecipeBaobabcharcoal extends ElementsVenaMod.ModElement {
	public RecipeBaobabcharcoal(ElementsVenaMod instance) {
		super(instance, 43);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockBaobabwood.block, (int) (1)), new ItemStack(Items.COAL, (int) (0), 1), 0F);
	}
}
