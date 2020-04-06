
package net.mcreator.venamod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.venamod.item.ItemCandyCane;
import net.mcreator.venamod.ElementsVenaMod;

@ElementsVenaMod.ModElement.Tag
public class TabJolinTab extends ElementsVenaMod.ModElement {
	public TabJolinTab(ElementsVenaMod instance) {
		super(instance, 81);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabjolintab") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemCandyCane.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
