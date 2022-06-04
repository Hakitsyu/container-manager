package configuration.interfaces;

import java.io.File;

public interface IConfigurationLoaderContext<T extends IConfiguration> {
    T execute(File file);
}
