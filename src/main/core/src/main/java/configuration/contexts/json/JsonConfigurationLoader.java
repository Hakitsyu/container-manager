package configuration.contexts.json;

import com.google.gson.Gson;
import configuration.ConfigurationLoaderContext;
import configuration.contexts.json.exceptions.NotValidJsonException;
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

    @Override
    public File prepare(File file) {
        try {
            if (!JsonHelper.validate(file))
                throw new NotValidJsonException();
            return file;
        } catch (NotValidJsonException ex) {
            throw new RuntimeException(ex);
        }
    }
}
