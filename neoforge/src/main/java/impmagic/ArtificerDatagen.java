package impmagic;

import impmagic.datagen.ArtificerBlockTagProvider;
import impmagic.datagen.ArtificerEnglishLanguageProvider;
import impmagic.datagen.ArtificerLootTableProvider;
import impmagic.datagen.ArtificerModelProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class ArtificerDatagen {
    private ArtificerDatagen(){
    }

    public static void  onGatherClientData(GatherDataEvent.Client event) {
        event.createProvider(ArtificerModelProvider::new);
        event.createProvider(ArtificerEnglishLanguageProvider::new);
        event.createProvider(ArtificerBlockTagProvider::new);
        event.createProvider((ArtificerLootTableProvider::new));
    }
}
