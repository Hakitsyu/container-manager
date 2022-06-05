package configuration.interfaces;

import java.io.File;

public interface IConfigurationWriterContext<T extends IConfiguration> extends IConfigurationPrepareContext {
    File execute(File file, T obj);
}
