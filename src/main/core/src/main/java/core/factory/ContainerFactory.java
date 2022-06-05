package core.factory;

import core.Container;
import core.configuration.ContainerConfiguration;
import core.configuration.ContainerConfigurationWriter;
import core.interfaces.IContainerFactory;
import file.AsyncDirectoryHandler;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class ContainerFactory extends AsyncDirectoryHandler implements IContainerFactory {
    private static final String DEFAULT_CONFIG_FILE = "config.json";

    private ContainerConfiguration configuration;
    private String configurationFile;
    private ContainerFactoryOptions options;

    public ContainerFactory(String containersPath) {
        this(Paths.get(containersPath), new ContainerFactoryOptions());
    }

    public ContainerFactory(Path containersPath) {
        this(containersPath, new ContainerFactoryOptions());
    }

    public ContainerFactory(String containersPath, ContainerFactoryOptions options) {
        this(Paths.get(containersPath), options);
    }

    public ContainerFactory(Path containersPath, ContainerFactoryOptions options) {
        super(containersPath);
        this.options = options;
        this.configurationFile = DEFAULT_CONFIG_FILE;
    }

    private void createConfiguration(File directory) {
        if (this.configuration == null) return;

        String configurationPath = Paths.get(directory.getPath(), this.configurationFile).toString();
        new ContainerConfigurationWriter().write(configurationPath, this.configuration);
    }

    public ContainerFactory configurationFile(String configurationFile) {
        this.configurationFile = configurationFile;
        return this;
    }

    public ContainerFactory configuration(ContainerConfiguration configuration) {
        this.configuration = configuration;
        return this;
    }

    public ContainerFactory options(ContainerFactoryOptions options) {
        this.options = options;
        return this;
    }

    public Container create() {
        File directory = this.generateDirectory();
        this.createConfiguration(directory);
        return null;
    }

    private String generateDirectoryName() {
        String letters = "ABCDEFGHIJKMLNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < options.getDirectoryNameSize(); i++)
            builder.append(letters.charAt(new Random().nextInt(letters.length() - 1)));
        return builder.toString();
    }

    private File generateDirectory() {
        try {
            String name = this.generateDirectoryName();
            this.mkdir(name);

            return this.getFile(name).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
