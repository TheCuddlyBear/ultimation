package me.thecuddlybear.ultimation;

import me.thecuddlybear.ultimation.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab ULTIMATION_TAB = new CreativeModeTab("ultimationTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack((ModItems.TITANIUM_INGOT.get()));
        }
    };

}
