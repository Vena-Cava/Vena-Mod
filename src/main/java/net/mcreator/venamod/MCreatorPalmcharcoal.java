package net.mcreator.venamod;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

@Elementsvenamod.ModElement.Tag
public class MCreatorPalmcharcoal extends Elementsvenamod.ModElement {
	public MCreatorPalmcharcoal(Elementsvenamod instance) {
		super(instance, 29);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(MCreatorPalmwood.block, (int) (1)), new ItemStack(Items.COAL, (int) (1), 1), 1F);
	}
}
