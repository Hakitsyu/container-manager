package configuration;

import configuration.interfaces.IConfiguration;
import configuration.interfaces.IConfigurationWriter;
import configuration.interfaces.IConfigurationWriterContext;

import java.io.File;

public abstract class ConfigurationWriter<T extends IConfiguration> implements IConfigurationWriter<T> {
    protected IConfigurationWriterContext<T> context;

    public ConfigurationWriter(IConfigurationWriterContext<T> context) {
        this.context = context;
    }

    public abstract File write(String path, T obj);
}
