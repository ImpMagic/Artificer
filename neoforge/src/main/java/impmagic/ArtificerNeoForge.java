package impmagic;


import impmagic.services.NeoForgeRegistryHelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class ArtificerNeoForge {

    public ArtificerNeoForge(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello from Artificer Mod!");
        CommonClass.init();
        NeoForgeRegistryHelper.register(eventBus);
    }
}