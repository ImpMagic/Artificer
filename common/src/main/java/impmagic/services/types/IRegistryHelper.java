package impmagic.services.types;
// Holds all registry methods.


import impmagic.Constants;
import impmagic.services.types.util.BlockWithItemRegistryHandle;
import impmagic.services.types.util.RegistryHandle;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface IRegistryHelper {
    // Registers the block and blockItem at the same time instead of two methods as was in the ModBlocks file.
    default <T extends Block> BlockWithItemRegistryHandle<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> block){
        return registerBlockWithItem(name, block, BlockItem::new);
    }
    // Same as line above but add function for properties.
    default <T extends Block> BlockWithItemRegistryHandle<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> block, BiFunction<Block, Item.Properties, BlockItem> item){
        //This is the same as was done in ModBlocks.
        RegistryHandle<T> blockHandle = registerBlock(name, block);
        RegistryHandle<BlockItem> itemHandle = registerBlockItem(name, blockHandle, item);
        return new BlockWithItemRegistryHandle<>(blockHandle,itemHandle);
    }

    // Method to register a block, BlockBehavior.Properties is the same as Item.Properties but for blocks.
    <T extends Block> RegistryHandle<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block);

    // Each block item is associated to a block, why have RegistryHandle of a block and then pass block into function that constructs the item.
    <T extends BlockItem> RegistryHandle<T> registerBlockItem(String name, RegistryHandle<? extends Block> block, BiFunction<Block, Item.Properties, T> item);

    // Make generic interface so can create registries for multiple types (item, block, entity, etc.)
    <T extends Item> RegistryHandle<T> registerItem(String name, Function<Item.Properties, T> item);

    static ResourceKey<Block> blockKey(String name){
        return ResourceKey.create(Registries.BLOCK, Constants.id(name));  //Constants is a class with string values for some values.
    }

    static ResourceKey<Item> itemKey(String name){
        return ResourceKey.create(Registries.ITEM, Constants.id(name));  //Constants is a class with string values for some values.
    }
}
