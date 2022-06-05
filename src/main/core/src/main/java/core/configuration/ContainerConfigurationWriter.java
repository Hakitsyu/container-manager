package core.configuration;

import configuration.ConfigurationWriter;
import configuration.contexts.json.JsonConfigurationWriter;
import java.io.File;

public class ContainerConfigurationWriter extends ConfigurationWriter<ContainerConfiguration> {
    public ContainerConfigurationWriter() {
        super(new JsonConfigurationWriter());
    }

    @Override
    public File write(String path, ContainerConfiguration obj) {
        return context.execute(context.prepare(new File(path)), obj);
    }
}
