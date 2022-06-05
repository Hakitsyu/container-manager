package configuration;

import configuration.interfaces.IConfiguration;
import configuration.interfaces.IConfigurationLoader;
import configuration.interfaces.IConfigurationLoaderContext;

public abstract class ConfigurationLoader<T extends IConfiguration> implements IConfigurationLoader<T> {
    protected IConfigurationLoaderContext<T> context;

    public ConfigurationLoader(IConfigurationLoaderContext<T> context) {
        this.context = context;
    }

    public abstract T load();
}
