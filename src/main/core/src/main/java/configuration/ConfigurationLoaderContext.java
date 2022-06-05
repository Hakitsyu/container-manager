package configuration;

import configuration.contexts.json.exceptions.NotValidJsonException;
import configuration.interfaces.IConfiguration;
import configuration.interfaces.IConfigurationLoaderContext;

import java.io.File;

public abstract class ConfigurationLoaderContext<T extends IConfiguration> implements IConfigurationLoaderContext<T> {
    protected Class<T> classz;

    public ConfigurationLoaderContext(Class<T> classz) {
        this.classz = classz;
    }

    public abstract T execute(File file);
    public abstract File prepare(File file);
}
