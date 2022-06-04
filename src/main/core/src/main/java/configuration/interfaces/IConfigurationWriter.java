package configuration.interfaces;

import java.io.File;

public interface IConfigurationWriter<T extends IConfiguration> {
    File write(String path, T obj);
}
