package impmagic.datagen;

import impmagic.Constants;
import impmagic.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ArtificerBlockTagProvider extends BlockTagsProvider {
    public ArtificerBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Constants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            // For more blocks enter another .add line or can put comma after existing .add with ModBlocks.etc.
            .add(ModBlocks.EXAMPLE_BLOCK.block().get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.EXAMPLE_BLOCK.block().get());
    }
}
