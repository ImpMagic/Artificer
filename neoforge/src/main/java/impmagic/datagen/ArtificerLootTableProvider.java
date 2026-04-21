package impmagic.datagen;

import impmagic.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ArtificerLootTableProvider extends LootTableProvider {
    public ArtificerLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(
                output,
                Set.of(),
                List.of(
                        new SubProviderEntry(ArtificerBlockLootSubProvider::new, LootContextParamSets.BLOCK)
                        // , code for another SubProvider        use to add another type of SubProvider (ex. entity)
                        // then add new class as below
                ),
                registries);
    }

    private static final class ArtificerBlockLootSubProvider extends BlockLootSubProvider {

        // First super parameter is blast resistance, to add on between () put ModItems.BLOCK_NAME.get().
        // Second super parameter is enabledFeatures, can add to if want.
        ArtificerBlockLootSubProvider(HolderLookup.Provider registries) {
            super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
        }

        // Contains all loot tables.
        @Override
        protected void generate() {
            dropSelf(ModBlocks.EXAMPLE_BLOCK.block().get());   // Uses default loot table.
        }
    }
}
