package net.mcreator.venamod;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

@Elementsvenamod.ModElement.Tag
public class MCreatorPalmstemcharcoal extends Elementsvenamod.ModElement {
	public MCreatorPalmstemcharcoal(Elementsvenamod instance) {
		super(instance, 30);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorPalmstem.block, (int) (1)), new ItemStack(Items.COAL, (int) (1), 1), 1F);
	}
}
