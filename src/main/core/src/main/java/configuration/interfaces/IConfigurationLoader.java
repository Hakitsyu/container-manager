package configuration.interfaces;

public interface IConfigurationLoader<T extends IConfiguration> {
    T load();
}
