package core.configuration;

import configuration.ConfigurationLoader;
import configuration.contexts.json.JsonConfigurationLoader;
import configuration.contexts.json.exceptions.NotValidJsonException;

import java.nio.file.Path;

public class ContainerConfigurationLoader extends ConfigurationLoader<ContainerConfiguration> {
    private final Path path;

    public ContainerConfigurationLoader(Path path) {
        super(new JsonConfigurationLoader<>(ContainerConfiguration.class));
        this.path = path;
    }

    @Override
    public ContainerConfiguration load() {
        return context.execute(context.prepare(path.toFile()));
    }
}
