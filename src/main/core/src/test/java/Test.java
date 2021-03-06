import core.Container;
import core.configuration.ContainerConfigurationBuilder;
import core.factory.ContainerFactory;

public class Test {
    public static void main(String[] args) {
        ContainerFactory factory = new ContainerFactory("C:\\ContainerManager\\");
        factory.configuration(new ContainerConfigurationBuilder()
                .name("Test.......")
                .build());
        Container container = factory.create();

        factory.configuration(
                new ContainerConfigurationBuilder()
                    .name("Second test...")
                    .build())
                .configurationFile("other_config.json");
        Container otherContainer = factory.create();
    }
}