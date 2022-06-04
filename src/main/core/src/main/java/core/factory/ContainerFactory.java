package core.factory;

import constants.Constants;
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
    private Path path;

    private ContainerConfiguration configuration;
    private ContainerFactoryOptions options;

    public ContainerFactory(Path containersPath) {
        super(containersPath);
        this.path = containersPath;
        this.options = new ContainerFactoryOptions();
    }

    public ContainerFactory(String containersPath) {
        super(containersPath);
        this.path = Paths.get(containersPath);
        this.options = new ContainerFactoryOptions();
    }

    public ContainerFactory(Path containersPath, ContainerFactoryOptions options) {
        super(containersPath);
        this.path = containersPath;
        this.options = options;
    }

    public ContainerFactory(String containersPath, ContainerFactoryOptions options) {
        super(containersPath);
        this.path = Paths.get(containersPath);
        this.options = options;
    }

    private void createConfiguration(File directory) {
        if (this.configuration == null) return;

        String configurationPath = Paths.get(directory.getPath(), Constants.CONFIGURATION_FILE).toString();
        new ContainerConfigurationWriter().write(configurationPath, this.configuration);
    }

    public ContainerFactory configuration(ContainerConfiguration configuration) {
        this.configuration = configuration;
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
