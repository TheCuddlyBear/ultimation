package me.thecuddlybear.ultimation.block;

import me.thecuddlybear.ultimation.ModCreativeModeTab;
import me.thecuddlybear.ultimation.Ultimation;
import me.thecuddlybear.ultimation.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ultimation.MOD_ID);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(12f)), CreativeModeTab.TAB_MISC);
    public static final RegistryObject<StoneButtonBlock> TITANIUM_BUTTON = registerBlock("titanium_button", () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)), CreativeModeTab.TAB_MISC);

    //TODO: fix weathering Copper Button
    public static final RegistryObject<CustomWeatheringButtonBlock> COPPER_BUTTON = registerBlock("copper_button", () -> new CustomWeatheringButtonBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of(Material.METAL)), ModCreativeModeTab.ULTIMATION_TAB);
    public static final RegistryObject<CustomWeatheringButtonBlock> EXPOSED_COPPER_BUTTON = registerBlock("exposed_copper_button", () -> new CustomWeatheringButtonBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of(Material.METAL)), ModCreativeModeTab.ULTIMATION_TAB);
    public static final RegistryObject<CustomWeatheringButtonBlock> WEATHERED_COPPER_BUTTON = registerBlock("weathered_copper_button", () -> new CustomWeatheringButtonBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of(Material.METAL)), ModCreativeModeTab.ULTIMATION_TAB);
    public static final RegistryObject<CustomWeatheringButtonBlock> OXIDIZED_COPPER_BUTTON = registerBlock("oxidized_copper_button", () -> new CustomWeatheringButtonBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of(Material.METAL)), ModCreativeModeTab.ULTIMATION_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
