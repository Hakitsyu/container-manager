package configuration.contexts;

import com.google.gson.Gson;
import configuration.ConfigurationLoaderContext;
import configuration.interfaces.IConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonConfigurationLoader<T extends IConfiguration> extends ConfigurationLoaderContext<T> {
    public JsonConfigurationLoader(Class<T> classz) {
        super(classz);
    }

    @Override
    public T execute(File file) {
        try {
            return new Gson().fromJson(new FileReader(file), classz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
