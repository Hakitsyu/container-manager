package configuration.interfaces;

import java.io.File;

public interface IConfigurationWriterContext<T extends IConfiguration> {
    File execute(String path, T obj);
}
