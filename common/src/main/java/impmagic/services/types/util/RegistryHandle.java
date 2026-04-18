package impmagic.services.types.util;

import com.google.common.base.Supplier;
import net.minecraft.resources.Identifier;

public interface RegistryHandle<T> extends Supplier<T> {
    Identifier id();
}
