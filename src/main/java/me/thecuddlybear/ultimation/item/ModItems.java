package me.thecuddlybear.ultimation.item;

import me.thecuddlybear.ultimation.ModCreativeModeTab;
import me.thecuddlybear.ultimation.Ultimation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ultimation.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ULTIMATION_TAB)));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ULTIMATION_TAB)));
    public static final RegistryObject<Item> RAW_TITANIUM_ORE = ITEMS.register("raw_titanium_ore", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ULTIMATION_TAB)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
