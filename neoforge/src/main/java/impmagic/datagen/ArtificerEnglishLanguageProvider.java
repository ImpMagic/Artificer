package impmagic.datagen;

import impmagic.Constants;
import impmagic.init.ModBlocks;
import impmagic.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ArtificerEnglishLanguageProvider extends LanguageProvider {
    public ArtificerEnglishLanguageProvider(PackOutput output) {
        super(output, Constants.MOD_ID, "en_us");  // Creates .json file called en_us.
    }

    @Override
    protected void addTranslations() {
        add(ModItems.EXAMPLE_ITEM.get(), "Example Item");
        add(ModItems.EXAMPLE_ITEM2.get(), "Example Item 2");
        add(ModBlocks.EXAMPLE_BLOCK.block().get(), "Example Block");
        add(ModBlocks.EXAMPLE_BLOCK.item().get(), "Example Block");
    }

    // Used to add translatable strings in datagen.
    private void add(Component component, String value){
        if(component.getContents() instanceof TranslatableContents translatableContents){
            add(translatableContents.getKey(), value);
        }
    }
}
