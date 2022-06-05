package configuration.interfaces;

import java.io.File;

public interface IConfigurationLoaderContext<T extends IConfiguration> extends IConfigurationPrepareContext {
    T execute(File file);
}
