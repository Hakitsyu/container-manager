package configuration;

import configuration.contexts.json.exceptions.NotValidJsonException;
import configuration.interfaces.IConfiguration;
import configuration.interfaces.IConfigurationWriterContext;

import java.io.File;

public abstract class ConfigurationWriterContext<T extends IConfiguration> implements IConfigurationWriterContext<T> {
    public abstract File execute(File file, T obj);
    public abstract File prepare(File file);
}
