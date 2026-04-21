package impmagic.datagen;

import impmagic.Constants;
import impmagic.init.ModBlocks;
import impmagic.init.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ArtificerModelProvider extends ModelProvider {
    public ArtificerModelProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels){
        itemModels.generateFlatItem(ModItems.EXAMPLE_ITEM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_ITEM2.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocks.EXAMPLE_BLOCK.block().get());
    }
}
