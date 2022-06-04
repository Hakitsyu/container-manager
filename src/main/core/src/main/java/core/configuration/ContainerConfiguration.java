package core.configuration;

import configuration.interfaces.IConfiguration;

public class ContainerConfiguration implements IConfiguration {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
