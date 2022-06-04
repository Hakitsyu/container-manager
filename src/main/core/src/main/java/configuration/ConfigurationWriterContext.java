package configuration;

import configuration.interfaces.IConfiguration;
import configuration.interfaces.IConfigurationWriterContext;

import java.io.File;

public abstract class ConfigurationWriterContext<T extends IConfiguration> implements IConfigurationWriterContext<T> {
    public abstract File execute(String path, T obj);
}
