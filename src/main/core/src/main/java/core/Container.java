package core;

import core.configuration.ContainerConfiguration;
import core.configuration.ContainerConfigurationLoader;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Container {

    private Path path;
    private ContainerConfiguration configuration;

    public Container(Path path) {
        initialize(path);
    }

    public Container(String path) {
        initialize(Paths.get(path));
    }

    private void initialize(Path path) {
        this.path = path;
        this.reloadConfiguration();
    }

    private void reloadConfiguration() {
        this.configuration = new ContainerConfigurationLoader(getConfigurationPath()).load();
    }

    public ContainerConfiguration getConfiguration() {
        return configuration;
    }

    public Path getConfigurationPath() {
        return Paths.get(path.toString(), "config.json");
    }
}
