package impmagic.init;

import impmagic.services.types.Services;
import impmagic.services.types.util.BlockWithItemRegistryHandle;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public final class ModBlocks {
    private ModBlocks() {
        // Suggested to have this constructor throw new UnsupportedOperationException("This is a registry class.");
        // Same in ModItems.
    }

    public static void load() {
    }

    public static final BlockWithItemRegistryHandle<Block> EXAMPLE_BLOCK = Services.REGISTRY.registerBlockWithItem("example_block",
                properties -> new Block(properties.strength(3.0F, 3.0F).requiresCorrectToolForDrops()));

    public static final BlockWithItemRegistryHandle<Block> ORANIUM_ORE = Services.REGISTRY.registerBlockWithItem("oranium_ore",
            properties -> new Block(properties.strength(3.0F, 3.0F).requiresCorrectToolForDrops()));

    // Can add this line to add properties, without it create a default block item.
    //15.0F)), ((block, properties) -> new BlockItem(block, properties.stacksTo(32))));

    // This is a way to register a block item for the above block.
    // Instead, created class BlockWitihItemRegistryHolder in services + util to register the block and block item at the same time.
    // At end add any properties for the block.
    //public static final RegistryHandle<Block> EXAMPLE_BLOCK = Services.REGISTRY.registerBlock("example_block",
    //            properties -> new Block(properties.strength(3.0F, 15.0F)));

    // public static final RegistryHandle<BlockItem> EXAMPLE_BLOCK_ITEM = Services.REGISTRY.registerBlockItem("example_block",
    //        EXAMPLE_BLOCK, ((block, properties) -> new BlockItem(block, properties.stacksTo(32))));
}
