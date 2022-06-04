package core.configuration;

import configuration.ConfigurationLoader;
import configuration.contexts.JsonConfigurationLoader;

import java.nio.file.Path;

public class ContainerConfigurationLoader extends ConfigurationLoader<ContainerConfiguration> {
    private Path path;

    public ContainerConfigurationLoader(Path path) {
        super(new JsonConfigurationLoader<>(ContainerConfiguration.class));
        this.path = path;
    }

    @Override
    public ContainerConfiguration load() {
        System.out.printf(path.toFile().getAbsolutePath());
        return context.execute(path.toFile());
    }
}
