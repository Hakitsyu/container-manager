package core.configuration;

import core.interfaces.IContainerConfigurationBuilder;

public class ContainerConfigurationBuilder implements IContainerConfigurationBuilder {
    private ContainerConfiguration configuration;

    public ContainerConfigurationBuilder() {
        this.configuration = new ContainerConfiguration();
    }

    public ContainerConfigurationBuilder name(String name) {
        this.configuration.setName(name);
        return this;
    }

    @Override
    public ContainerConfiguration build() {
        return configuration;
    }
}
