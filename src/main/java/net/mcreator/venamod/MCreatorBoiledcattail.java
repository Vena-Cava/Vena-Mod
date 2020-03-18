package net.mcreator.venamod;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@Elementsvenamod.ModElement.Tag
public class MCreatorBoiledcattail extends Elementsvenamod.ModElement {
	public MCreatorBoiledcattail(Elementsvenamod instance) {
		super(instance, 15);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorCattailhead.block, (int) (1)), new ItemStack(MCreatorBoiledcattailhead.block, (int) (1)), 1F);
	}
}
