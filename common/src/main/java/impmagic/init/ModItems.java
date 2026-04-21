package impmagic.init;
// Class where registration for all items exist.

import impmagic.services.types.Services;
import impmagic.services.types.util.RegistryHandle;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class ModItems {
    private ModItems(){
    }

    // Called so minecraft game knows that this class exists.
    public static void load() {

    }

    // Item name can only have lowercase letters, numbers, and underscores.
    // Make name the same as the field name (uppercase word)
    //Can add more properties, ex. properties.stacksTo(32).food(new FoodProperties(.nutrition())

    public static final RegistryHandle<Item> EXAMPLE_ITEM = Services.REGISTRY.registerItem("example_item",
            properties -> new Item(properties.stacksTo(32)));
    public static final RegistryHandle<Item> EXAMPLE_ITEM2 = Services.REGISTRY.registerItem("example_item2",
            Item::new);  //as one above but uses lambda
}